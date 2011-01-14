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

    SurveyDTO getSurvey(int surveyID);
    SurveyPageDTO getSurveyPage(int surveyID, int pageNo);
    SurveyPageDTO saveSurveyPageResponse(String username, SurveyPageDTO surveyPage);
    SurveyDTO submitResponse(String username, int surveyID);
    SurveyDTO deleteResponse(String username, int surveyID);
    
    ArrayList<SurveyDTO> findOpenSurveys(int maxRecords);
    ArrayList<SurveyDTO> findSurveysByState(String username, ActivityTypes state);
    ArrayList<SurveyDTO> findSurveys(SurveySearchCriteriaDTO criteria);
}
