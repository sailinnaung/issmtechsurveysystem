/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import survey.dto.*;

/**
 *
 * @author vivek
 */
@Stateless
public class RespondentSurveyFacadeBean implements RespondentSurveyFacadeRemote {

    public SurveyDTO getSurvey(int surveyID) {
        return null;
    }

    public SurveyDTO deleteResponse(String username, int surveyID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findOpenSurveys(int maxRecords) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, ActivityTypes state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyAnswerDTO getSurveryReponse(String username, int surveyID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyDTO getSurvey(String username, int surveyID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyPageDTO getSurveyPage(String username, int surveyID, int surveyPageID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyPageDTO saveSurveyPageResponse(String username, SurveyPageDTO surveyPage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyDTO submitResponse(String username, int surveyID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
