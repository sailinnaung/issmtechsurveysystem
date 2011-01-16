/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Remote;
import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author vivek
 */
@Remote
public interface RespondentSurveyFacadeRemote {

    SurveyDTO getSurvey(String username, int surveyID) throws UserNotFoundException, 
            RecordNotFoundException;
    
    SurveyPageDTO getSurveyPage(String username, int surveyID, int surveyPageID)
            throws UserNotFoundException, RecordNotFoundException;
    
    SurveyAnswerDTO createSurveyResponse(String username, int surveyPageID)
            throws UserNotFoundException, OperationFailedException, RecordExistsException;
    
    SurveyPageAnswerDTO saveSurveyPageResponse(String username, int surveyAnswerID, int surveyPageID, SurveyPageAnswerDTO surveyPage)
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException;
    
    SurveyAnswerDTO getSurveyResponse(String username, int surveyAnswerID)
            throws UserNotFoundException;
    
    SurveyAnswerDTO getSurveyResponseBySurvey(String username, int surveyID)
            throws UserNotFoundException;
    
    SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID)
            throws UserNotFoundException;
    
    boolean submitResponse(String username, int surveyAnswerID) 
            throws UserNotFoundException;
    
    boolean deleteResponse(String username, int surveyAnswerID)
            throws UserNotFoundException;
    
    ArrayList<SurveyDTO> findOpenSurveys(int maxRecords);
    ArrayList<SurveyAnswerDTO> findSurveysByState(String username, int state);
}
