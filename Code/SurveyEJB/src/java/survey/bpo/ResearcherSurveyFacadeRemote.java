/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Remote;
import survey.dto.*;
import survey.exception.*;
import java.util.ArrayList;

/**
 *
 * @author vivek
 */
@Remote
public interface ResearcherSurveyFacadeRemote {
    
    ArrayList<SurveyDTO> findSurveysByState(String username, int state);
    
    ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria);
    
    SurveyDTO createSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, OperationFailedException, 
            InvalidFieldException;
    
    SurveyDTO getSurvey(String username, int surveyID) 
            throws UserNotFoundException;
    
    SurveyDTO updateSurvey(String username, SurveyDTO survey);
    
    boolean deleteSurvey(String username, int surveyID);
    
    SurveyPageDTO getSurveyPage(String username, int surveyPageID)
            throws UserNotFoundException;
    
    SurveyPageDTO createSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage)
            throws UserNotFoundException, OperationFailedException, SurveyNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    SurveyPageDTO updateSurveyPage(int surveyID, SurveyPageDTO surveyPage);
    
    boolean deleteSurveyPage(int surveyID, int surveyPageID);
    
    QuestionDTO createQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question)
            throws UserNotFoundException, OperationFailedException, SurveyNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    QuestionDTO updateQuestion(int surveyID, int surveyPageID, QuestionDTO question);
    
    boolean deleteQuestion(int surveyID, int surveyPageID, int questionID);
}
