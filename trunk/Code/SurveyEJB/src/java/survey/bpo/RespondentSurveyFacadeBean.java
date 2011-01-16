/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import survey.dto.*;
import survey.exception.*;
import survey.dao.*;

/**
 *
 * @author vivek
 */
@Stateless
public class RespondentSurveyFacadeBean implements RespondentSurveyFacadeRemote {

    public SurveyDTO getSurvey(String username, int surveyID) throws UserNotFoundException, 
            RecordNotFoundException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyDTO survey = null;
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        survey = dao.getSurvey(surveyID);
        
        if (survey.getState() != ActivityTypes.SUBMIT)
            throw new RecordNotFoundException("Survey is not available");
        
        return survey;
    }

    public SurveyPageDTO getSurveyPage(String username, int surveyID, int surveyPageID) 
            throws UserNotFoundException, RecordNotFoundException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyHelper surveyHelper = new SurveyHelper();
        SurveyDTO survey = surveyHelper.checkSurveyExists(surveyID);
        if (survey.getState() != ActivityTypes.SUBMIT)
            throw new RecordNotFoundException("Survey is not available");
        
        SurveyPageDTO surveyPage = null;
        SurveyPageDAO dao = DAOFactory.getSurveyPageDAO();
        surveyPage = dao.getSurveyPage(surveyPageID);
        
        return surveyPage;
    }
    
    public SurveyAnswerDTO createSurveyResponse(String username, int surveyPageID)
            throws UserNotFoundException, OperationFailedException, RecordExistsException {
        
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyAnswerDTO answer = new SurveyAnswerDTO();
        answer.setState(ActivityTypes.DRAFT);
        
        SurveyResponseDAO dao = DAOFactory.getSurveyResponseDAO();
        answer = dao.createSurveyResponse(surveyPageID, username, answer);
        
        if (answer.getSurveyAnswerID() <= 0)
            throw new OperationFailedException("Operation could not be completed.");
        
        return answer;
    }
    
    public SurveyPageAnswerDTO saveSurveyPageResponse(String username, int surveyAnswerID, int surveyPageID, SurveyPageAnswerDTO pageAnswer) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException {
        
        // Save or update...
        // Check user
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyPageResponseDAO dao = DAOFactory.getSurveyPageResponseDAO();
        if (pageAnswer.getSurveyPageAnswerID() <= 0) {
            
            pageAnswer = dao.createSurveyPageResponse(surveyAnswerID, surveyPageID, pageAnswer);
            if (pageAnswer.getSurveyPageAnswerID() <= 0)
                throw new OperationFailedException("Operation coule not be completed");
        } else {
           
            pageAnswer = dao.updateSurveyPageResponse(surveyPageID, pageAnswer);
        }
        
        return pageAnswer;
    }

    public boolean deleteResponse(String username, int surveyAnswerID) throws UserNotFoundException {
        
        // Check user
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return false;
        
        SurveyResponseDAO dao = DAOFactory.getSurveyResponseDAO();
        return dao.deleteSurveyResponse(surveyAnswerID);
    }

    public ArrayList<SurveyDTO> findOpenSurveys(int maxRecords) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyAnswerDTO getSurveyResponse(String username, int surveyAnswerID) 
            throws UserNotFoundException {
        
        // Check user
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyResponseDAO dao = DAOFactory.getSurveyResponseDAO();
        return dao.getSurveyResponse(surveyAnswerID);
    }
    
    public SurveyAnswerDTO getSurveyResponseBySurvey(String username, int surveyID) 
            throws UserNotFoundException {
        
        // Check user
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyResponseDAO dao = DAOFactory.getSurveyResponseDAO();
        return dao.getSurveyResponse(username, surveyID);
    }

    public SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID) 
            throws UserNotFoundException {
        
        // Check user
        UserHelper userHelper = new UserHelper();
        UserDTO user = userHelper.checkUserExists(username);
        if (user == null)
            return null;
        
        SurveyPageResponseDAO dao = DAOFactory.getSurveyPageResponseDAO();
        return dao.getSurveyPageResponse(surveyPageAnswerID);
    }

    public boolean submitResponse(String username, int surveyAnswerID) 
            throws UserNotFoundException {
        
        
    }
}
