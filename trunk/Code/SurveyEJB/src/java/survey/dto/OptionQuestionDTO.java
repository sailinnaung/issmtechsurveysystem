/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author A0065956N
 */
public class OptionQuestionDTO extends QuestionDTO implements Serializable {

    public static final int ORIENTATION_H = 0;
    public static final int ORIENTATION_V = 1;
    public static final int ORDER_DEFAULT = 0;
    public static final int ORDER_RESPONSES = 1;
    
    private int questionType;   // QuestionTypes.CHECKBOX_MCQ, QuestionTypes.RADIO_MCQ, QuestionTypes.RATING
    private int orientation;
    private int printOrder;
    private int valueFrom;
    private int valueTo;
    private List<OptionDTO> options;
    
    public OptionQuestionDTO() {
        
        super();
        this.setPrintOrder(OptionQuestionDTO.ORDER_DEFAULT);
    }

    public List<OptionDTO> getOptions() {
        return this.options;
    }
    
    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(int printOrder) {
        this.printOrder = printOrder;
    }
    
    public int getQuestionType() {
        return questionType;
    }
    
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
        
        if (this.questionType == QuestionTypes.RATING) {
            this.printOrder = OptionQuestionDTO.ORDER_DEFAULT;
        }
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
}
