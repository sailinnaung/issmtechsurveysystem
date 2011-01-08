/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;

/**
 *
 * @author A0065956N
 */
public class RatingQuestionDTO extends OptionQuestionDTO implements Serializable {

    private NumberRangeDTO range;
    
    public RatingQuestionDTO() {
        
        super();
        this.setQuestionType(QuestionTypes.RATING);
        this.setMultiple(false);
    }

    public NumberRangeDTO getRange() {
        return range;
    }

    public void setRange(NumberRangeDTO range) {
        this.range = range;
    }
    
    public void setRange(int from, int to) {
        
        this.range = new NumberRangeDTO();
        this.range.setFrom(from);
        this.range.setTo(to);
    }
}
