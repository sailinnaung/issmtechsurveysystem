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
public class SurveyFacadeBean implements SurveyFacadeRemote {

    public SurveyDTO createSurvey(SurveyDTO survey) {
        return null;
    }

    public SurveyDTO updateSurvey(SurveyDTO survey) {
        return null;
    }

    public boolean deleteSurvey(int surveyID) {
        return false;
    }

    public SurveyDTO getSurvey(int surveyID) {
        return null;
    }
    
    public ArrayList<SurveyDTO> findSurveys(UserDTO owner) {
        return null;
    }
    
    public ArrayList<SurveyDTO> findSurveys(UserDTO owner, SurveySearchCriteriaDTO criteria) {
        return null;
    }

    public ArrayList<SurveyDTO> findSurveysByState(UserDTO owner, ActivityTypes state) {
        return null;
    }

    public QuestionDTO addSurveyQuestion(int surveyID, int pageNo, QuestionDTO question) {
        return null;
    }

    public QuestionDTO updateSurveyQuestion(int surveyID, int pageNo, QuestionDTO question) {
        return null;
    }

    public boolean deleteSurveyQuestion(int surveyID, int pageNo, int questionID) {
        return false;
    }
}
