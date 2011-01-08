/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.util.ArrayList;

/**
 *
 * @author A0065956N
 */
public class NumberQuestionDTO extends TextQuestionDTO implements java.io.Serializable {

    private ArrayList<NumberRangeDTO> ranges;
    
    public NumberQuestionDTO() {
        super();
        this.setQuestionType(QuestionTypes.NUMBER);
        this.setRestrictions("[0-9]*");
    }

    public ArrayList<NumberRangeDTO> getRanges() {
        return ranges;
    }

    public void setRanges(ArrayList<NumberRangeDTO> ranges) {
        this.ranges = ranges;
    }
}
