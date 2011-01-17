/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import survey.dao.*;
import survey.dto.*;
import survey.exception.*;
import survey.utils.*;

/**
 *
 * @author A0065956N
 */
class QuestionHelper {

    boolean checkQuestionFields(QuestionDTO question) throws InvalidFieldException {
        
        // Check the code
        if (StringHelper.checkStringEmpty(question.getCode()))
            throw new InvalidFieldException("Question Code cannot be empty");
        
        // Check the text
        if (StringHelper.checkStringEmpty(question.getText()))
            throw new InvalidFieldException("Question text cannot be empty");
        
        return true;
    }
    
    QuestionDTO checkQuestionExists(int questionID) throws RecordNotFoundException {
        
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        QuestionDTO question = dao.checkQuestion(questionID);
        
        if (question == null)
            throw new RecordNotFoundException("Question is not valid");
        
        return question;
    }
    
    boolean checkOptionFields(OptionDTO option) throws InvalidFieldException {
        
        if (StringHelper.checkStringEmpty(option.getCode()))
            throw new InvalidFieldException("Option code cannot be empty");
        
        if (StringHelper.checkStringEmpty(option.getName()))
            throw new InvalidFieldException("Option name cannot be empty");
        
        return true;
    }
    
    OptionDTO checkOptionExists(int optionID) throws RecordNotFoundException {
        
        SurveyQuestionDAO dao = DAOFactory.getSurveyQuestionDAO();
        OptionDTO option = dao.checkQuestionOption(optionID);
        
        if (option == null)
            throw new RecordNotFoundException("Option is not valid");
        
        return option;
    }
}
