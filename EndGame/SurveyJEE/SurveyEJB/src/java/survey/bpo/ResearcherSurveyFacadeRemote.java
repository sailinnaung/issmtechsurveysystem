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
    
    SurveyDTO getSurvey(String username, String code)
            throws UserNotFoundException;
    
    SurveyDTO updateSurvey(String username, SurveyDTO survey) 
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException, 
            InvalidFieldException;
    
    boolean deleteSurvey(String username, int surveyID)
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException;
    
    SurveyPageDTO getSurveyPage(String username, int surveyPageID)
            throws UserNotFoundException;
    
    SurveyPageDTO createSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage)
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    SurveyPageDTO updateSurveyPage(String username, int surveyID, SurveyPageDTO surveyPage)
            throws UserNotFoundException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    boolean deleteSurveyPage(String username, int surveyID, int surveyPageID)
            throws UserNotFoundException, RecordNotFoundException, UserNotAllowedException;
    
    QuestionDTO createQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question)
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    QuestionDTO updateQuestion(String username, int surveyID, int surveyPageID, QuestionDTO question)
            throws UserNotFoundException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    boolean deleteQuestion(String username, int surveyID, int surveyPageID, int questionID)
            throws UserNotFoundException, UserNotAllowedException, RecordNotFoundException;
    
    OptionDTO createQuestionOption(String username, int questionID, OptionDTO option)
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException,
            InvalidFieldException, UserNotAllowedException;
    
    OptionDTO updateQuestionOption(String username, int questionID, OptionDTO option)
            throws UserNotFoundException, RecordNotFoundException, InvalidFieldException;
    
    boolean deleteQuestionOption(String username, int questionID, OptionDTO option)
            throws UserNotFoundException, RecordNotFoundException;
}
