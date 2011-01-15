/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Remote;
import survey.dto.*;

/**
 *
 * @author vivek
 */
@Remote
public interface RespondentSurveyFacadeRemote {

    SurveyDTO getSurvey(String username, int surveyID);
    SurveyPageDTO getSurveyPage(String username, int surveyID, int surveyPageID);
    SurveyPageDTO saveSurveyPageResponse(String username, SurveyPageDTO surveyPage);
    SurveyAnswerDTO getSurveryReponse(String username, int surveyID);
    SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID);
    SurveyDTO submitResponse(String username, int surveyID);
    SurveyDTO deleteResponse(String username, int surveyID);
    
    ArrayList<SurveyDTO> findOpenSurveys(int maxRecords);
    ArrayList<SurveyDTO> findSurveysByState(String username, ActivityTypes state);
    ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria);
}
