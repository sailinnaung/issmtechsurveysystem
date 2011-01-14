/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Remote;
import survey.dto.*;
import java.util.ArrayList;

/**
 *
 * @author vivek
 */
@Remote
public interface ResearcherSurveyFacadeRemote {
    
    ArrayList<SurveyDTO> findSurveysByState(String username, ActivityTypes state);
    ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria);
    SurveyDTO createSurvey(String username, SurveyDTO survey);
    SurveyDTO updateSurvey(String username, SurveyDTO survey);
    boolean deleteSurvey(String username, int surveyID);
    SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    SurveyPageDTO updateSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    boolean deleteSurveyPage(int surveyID, int surveyPageID);
    QuestionDTO createQuestion(int surveyID, int surveyPageID, QuestionDTO question);
    QuestionDTO updateQuestion(int surveyID, int surveyPageID, QuestionDTO question);
    boolean deleteQuestion(int surveyID, int surveyPageID, int questionID);
}
