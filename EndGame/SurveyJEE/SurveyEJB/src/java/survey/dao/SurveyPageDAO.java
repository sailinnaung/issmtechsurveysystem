/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author A0065956N
 */
public interface SurveyPageDAO {

    public SurveyPageDTO checkSurveyPage(int surveyPageID);
    public SurveyPageDTO getSurveyPage(int surveyPageID);
    public SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    public SurveyPageDTO updateSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    public boolean deleteSurveyPage(int surveyPageID);
}
