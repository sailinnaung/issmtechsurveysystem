/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import java.util.ArrayList;
import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author vivek
 */
public interface SurveyDAO {

    public SurveyDTO checkSurvey(int surveyID);
    public SurveyDTO getSurvey(int surveyID);
    public SurveyDTO createSurvey(SurveyDTO survey);
    public SurveyPageDTO checkSurveyPage(int surveyPageID);
    public SurveyPageDTO getSurveyPage(int surveyPageID);
    public SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    public QuestionDTO createQuestion(int surveyPageID, QuestionDTO question);
}
