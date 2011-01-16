/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import java.util.ArrayList;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public interface SurveyResponseDAO {

    public SurveyAnswerDTO checkSurveyResponse(int surveyAnswerID);
    
    public SurveyAnswerDTO checkSurveyResponse(String username, int surveyID);
    
    public SurveyAnswerDTO getSurveyResponse(int surveyAnswerID);
    
    public SurveyAnswerDTO getSurveyResponse(String username, int surveyID);
    
    public SurveyAnswerDTO createSurveyResponse(int surveyID, String username, SurveyAnswerDTO answer);
    
    public boolean deleteSurveyResponse(int surveyAnswerID);
    
    public boolean submitSurveyResponse(int surveyAnswerID);
    
    public ArrayList<SurveyAnswerDTO> findSurveysByState(String username, int state);
    
    public ArrayList<SurveyDTO> getOpenSurveys(int maxRecords);
    
    public int calcTotalResponses(int surveyID);
}
