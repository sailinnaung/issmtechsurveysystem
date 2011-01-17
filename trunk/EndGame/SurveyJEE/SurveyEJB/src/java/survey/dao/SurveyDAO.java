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
    public SurveyDTO getSurvey(String code);
    public SurveyDTO createSurvey(SurveyDTO survey);
    public SurveyDTO updateSurvey(SurveyDTO survey);
    public boolean deleteSurvey(int surveyID);
    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria);
    public ArrayList<SurveyDTO> findSurveys(String username, int state);
}
