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
    
    public SurveyDTO createSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, OperationFailedException, 
            InvalidFieldException, RecordExistsException {
        
        UserDTO owner = checkUserExists(username);
        if (owner == null)
            return null;
        
        if (survey.getSurveyID() > 0)
            throw new RecordExistsException("Survey record exists for ID: " + survey.getSurveyID());
        
        if (!checkSurveyFields(survey))
            return null;
        
        survey.setOwner(owner);
        survey.setState(ActivityTypes.DRAFT);
        survey.setCreateDate(Calendar.getInstance());
        survey.setUpdateDate(Calendar.getInstance());
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.createSurvey(username, survey);
        
        if (survey.getSurveyID() <= 0)
            throw new OperationFailedException("The survey could not be saved for the user: " + username);
        
        return survey;
    }
    
    public QuestionDTO createQuestion(int surveyID, int surveyPageID, QuestionDTO question) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage) {
        throw new UnsupportedOperationException("Not supported yet.");
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
