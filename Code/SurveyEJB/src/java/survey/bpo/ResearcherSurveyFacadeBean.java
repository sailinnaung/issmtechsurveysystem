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
public class ResearcherSurveyFacadeBean implements ResearcherSurveyFacadeRemote {

    public QuestionDTO createQuestion(int surveyID, int surveyPageID, QuestionDTO question) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public SurveyDTO createSurvey(String username, SurveyDTO survey) {
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
