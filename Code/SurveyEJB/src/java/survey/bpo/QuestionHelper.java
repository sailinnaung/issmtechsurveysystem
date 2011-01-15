/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.List;
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
    
    void calculateRatings(RatingQuestionDTO question) {
        
        List<OptionDTO> options = question.getOptions();
        if (options != null && options.size() > 0) {
            
            int from = question.getValueFrom();
            int to = question.getValueTo();
            
            if (from == 0 && to == 0) {
                from = 1;
                to = options.size();
            }
            
            float step = (to - from + 1.0F) / (float)options.size();
            float value = from;
            for (OptionDTO option : options) {
                
                option.setValue(value);
                value += step;
            }
        }
    }
}
