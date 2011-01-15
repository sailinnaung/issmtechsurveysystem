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
public interface SurveyQuestionDAO {

    public QuestionDTO checkQuestion(int questionID);
    public QuestionDTO getQuestion(int questionID);
    public QuestionDTO createQuestion(int surveyPageID, QuestionDTO question);
    public QuestionDTO updateQuestion(QuestionDTO question);
    public boolean deleteQuestion(int questionID);
   
    public OptionDTO checkQuestionOption(int optionID);
    public OptionDTO createQuestionOption(int questionID, OptionDTO option);
    public OptionDTO updateQuestionOption(int questionID, OptionDTO option);
    public boolean deleteQuestionOption(int questionID, OptionDTO option);
}
