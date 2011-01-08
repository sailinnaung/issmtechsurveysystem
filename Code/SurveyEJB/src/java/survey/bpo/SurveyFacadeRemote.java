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
public interface SurveyFacadeRemote {

    SurveyDTO createSurvey(SurveyDTO survey);

    SurveyDTO updateSurvey(SurveyDTO survey);

    boolean deleteSurvey(int surveyID);

    SurveyDTO getSurvey(int surveyID);
    
    ArrayList<SurveyDTO> findSurveys(UserDTO owner);
    
    ArrayList<SurveyDTO> findSurveys(UserDTO owner, SurveySearchCriteriaDTO criteria);

    ArrayList<SurveyDTO> findSurveysByState(UserDTO owner, ActivityTypes state);

    QuestionDTO addSurveyQuestion(int surveyID, int pageNo, QuestionDTO question);

    QuestionDTO updateSurveyQuestion(int surveyID, int pageNo, QuestionDTO question);

    boolean deleteSurveyQuestion(int surveyID, int pageNo, int questionID);

}
