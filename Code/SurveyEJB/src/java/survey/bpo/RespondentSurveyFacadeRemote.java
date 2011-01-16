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
    
    SurveyPageAnswerDTO saveSurveyPageResponse(String username, int surveyPageAnswerID, SurveyPageAnswerDTO surveyPage)
            throws UserNotFoundException, RecordNotFoundException;
    
    SurveyAnswerDTO getSurveryReponse(String username, int surveyID);
    SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID);
    SurveyDTO submitResponse(String username, int surveyID);
    SurveyDTO deleteResponse(String username, int surveyID);
    
    ArrayList<SurveyDTO> findOpenSurveys(int maxRecords);
    ArrayList<SurveyDTO> findSurveysByState(String username, int state);
    ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria);
}
