/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public SurveyDTO getSurvey(String username, int surveyID) 
            throws UserNotFoundException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
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
        
        UserHelper userHelper = new UserHelper();
        UserDTO owner = userHelper.checkUserExists(username);
        if (owner == null)
            return null;
        
        SurveyHelper surveyHelper = new SurveyHelper();
        if (!surveyHelper.checkSurveyFields(survey))
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
            
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
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
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check if title is empty
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        pageHelper.checkFields(surveyPage);
        
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
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        // Check if this is a valid survey
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        
        // Check if this user can change the survey
        if (survey.getOwner().getUserID() != user.getUserID())
            throw new UserNotAllowedException(username + " is not the owner of the survey");
        
        // Check survey page exists
        SurveyPageHelper pageHelper = new SurveyPageHelper();
        SurveyPageDTO surveyPage = pageHelper.checkSurveyPageExists(surveyPageID);
        
        // Check the fields
        QuestionHelper questionHelper = new QuestionHelper();
        if (!questionHelper.checkQuestionFields(question))
            throw null;
        
        // Set the state
        question.setState(ActivityTypes.DRAFT);
        
        // Calculate the values of the options if the type is RATING
        if (question.getQuestionType() == QuestionTypes.RATING) {
            
            questionHelper.calculateRatings((RatingQuestionDTO) question);
        }
        
        // Save to DB
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        question = dao.createQuestion(surveyPageID, question);
        
        if (question.getQuestionID() <= 0)
            throw new OperationFailedException("Question could not be created");
        
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
