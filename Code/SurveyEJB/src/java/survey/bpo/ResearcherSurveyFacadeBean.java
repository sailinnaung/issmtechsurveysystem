/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import java.util.Calendar;
import javax.ejb.Stateless;
import survey.dto.*;
import survey.exception.*;
import survey.dao.*;
import survey.utils.*;

/**
 *
 * @author vivek
 */
@Stateless(mappedName="ResearcherSurveyFacade")
public class ResearcherSurveyFacadeBean implements ResearcherSurveyFacadeRemote {

    private UserDTO checkUserExists(String username) throws UserNotFoundException {
        
        UserFacadeBean userFacade = new UserFacadeBean();
        UserDTO user = userFacade.getUserByUsername(username);
        
        if (user == null)
            throw new UserNotFoundException("User not found: " + username);
        
        return user;
    }
    
    private SurveyDTO checkSurveyExists(int surveyID) throws SurveyNotFoundException {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        // Check if this is a valid survey
        SurveyDTO survey = dao.getSurvey(surveyID);
        if (survey == null)
            throw new SurveyNotFoundException("Survey not found");
        
        return survey;
    }
    
    private SurveyPageDTO checkSurveyPageExists(int surveyPageID) throws SurveyNotFoundException {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        // Check if this is a valid survey
        SurveyPageDTO surveyPage = dao.getSurveyPage(surveyPageID);
        if (surveyPage == null)
            throw new SurveyNotFoundException("Survey Page not found");
        
        return surveyPage;
    }
    
    private boolean checkSurveyFields(SurveyDTO survey) throws InvalidFieldException {
        
        // Check if title is empty
        if (StringHelper.checkStringEmpty(survey.getTitle()))
            throw new InvalidFieldException("Survey title is empty");
        
        // Check if the start and end date are correct
        if (survey.getStartDate() == null)
            survey.setStartDate(Calendar.getInstance());
        
        Calendar startDate = DateHelper.removeTimestamp(survey.getStartDate());
        Calendar endDate = DateHelper.removeTimestamp(survey.getEndDate());
        if (startDate != null)
            DateHelper.removeTimestamp(startDate);
        
        if (endDate != null)
            DateHelper.removeTimestamp(endDate);
        
        if (!DateHelper.checkDateRange(startDate, endDate))
            throw new InvalidFieldException("The end date is not greater than the start date");
        
        // Check if the start date is today or later
        if (DateHelper.checkDateBeforeToday(startDate))
            throw new InvalidFieldException("The start date is before today");
        
        return true;
    }
    
    private boolean checkQuestionFields(QuestionDTO question) throws InvalidFieldException {
        
        // Check the code
        if (!StringHelper.checkStringEmpty(question.getCode()))
            throw new InvalidFieldException("Question Code cannot be empty");
        
        // Check the text
        if (!StringHelper.checkStringEmpty(question.getText()))
            throw new InvalidFieldException("Question text cannot be empty");
        
        return true;
    }
    
    private void calculateRatings(RatingQuestionDTO question) {
        
        if (question.getOptions().size() > 0) {
            
        }
    }
    
    public SurveyDTO getSurvey(String username, int surveyID) 
            throws UserNotFoundException {
        
        UserDTO user = checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyDTO survey = null;
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.getSurvey(surveyID);
        
        return survey;
    }
    
    public SurveyDTO createSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, OperationFailedException, 
            InvalidFieldException {
        
        UserDTO owner = checkUserExists(username);
        if (owner == null)
            return null;
        
        if (!checkSurveyFields(survey))
            return null;
        
        survey.setOwner(owner);
        survey.setState(ActivityTypes.DRAFT);
        survey.setCreateDate(Calendar.getInstance());
        survey.setUpdateDate(Calendar.getInstance());
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.createSurvey(survey);
        
        if (survey.getSurveyID() <= 0)
            throw new OperationFailedException("The survey could not be saved for the user: " + username);
        
        return survey;
    }
    
    public SurveyPageDTO getSurveyPage(String username, int surveyPageID)
            throws UserNotFoundException {
            
        UserDTO user = checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyPageDTO surveyPage = null;
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        surveyPage = dao.getSurveyPage(surveyPageID);
        
        return surveyPage;
    }
    
    public SurveyPageDTO createSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage) 
            throws UserNotFoundException, OperationFailedException, SurveyNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserDTO user = checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyDTO survey = checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check if title is empty
        if (StringHelper.checkStringEmpty(surveyPage.getTitle()))
            throw new InvalidFieldException("The title is mandatory");
        
        // Set the survey page state
        surveyPage.setState(ActivityTypes.DRAFT);
        
        // Save to DB
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        surveyPage = dao.createSurveyPage(surveyID, surveyPage);
        
        if (surveyPage.getSurveyPageID() <= 0)
            throw new OperationFailedException("Survey page could not be created.");
        
        return surveyPage;
    }

    public QuestionDTO createQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question) 
            throws UserNotFoundException, OperationFailedException, SurveyNotFoundException,
            InvalidFieldException, UserNotAllowedException {
        
        // Check if the user is found
        UserDTO user = checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyDTO survey = checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check survey page exists
        SurveyPageDTO surveyPage = checkSurveyPageExists(surveyPageID);
        
        // Check the fields
        if (!checkQuestionFields(question))
            throw null;
        
        // Set the state
        question.setState(ActivityTypes.DRAFT);
        
        if (question.getQuestionType() == QuestionTypes.RATING) {
            
            calculateRatings((RatingQuestionDTO) question);
        }
        
        return question;
    }
    
    public boolean deleteQuestion(int surveyID, int surveyPageID, int questionID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteSurvey(String username, int surveyID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteSurveyPage(int surveyID, int surveyPageID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public QuestionDTO updateQuestion(int surveyID, int surveyPageID, QuestionDTO question) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyDTO updateSurvey(String username, SurveyDTO survey) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyPageDTO updateSurveyPage(int surveyID, SurveyPageDTO surveyPage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
