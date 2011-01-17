/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public interface SurveyPageResponseDAO {

    public SurveyPageAnswerDTO checkSurveyPageResponse(int surveyPageAnswerID);
    
    public SurveyPageAnswerDTO getSurveyPageResponse(int surveyPageAnswerID);
    
    public SurveyPageAnswerDTO createSurveyPageResponse(int surveyAnswerID, int surveyPageID, SurveyPageAnswerDTO answer);
    
    public SurveyPageAnswerDTO updateSurveyPageResponse(int surveyPageID, SurveyPageAnswerDTO answer);
}
