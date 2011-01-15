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

    private int valueFrom;
    private int valueTo;
    
    public RatingQuestionDTO() {
        
        super();
        this.setMultipleFlg(false);
    }

    public int getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(int valueFrom) {
        this.valueFrom = valueFrom;
    }

    public int getValueTo() {
        return valueTo;
    }

    public void setValueTo(int valueTo) {
        this.valueTo = valueTo;
    }
    
    public int getQuestionType() {
        return QuestionTypes.RATING;
    }
}
