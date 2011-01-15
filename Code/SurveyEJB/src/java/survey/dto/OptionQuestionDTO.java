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
    
    private int orientation;
    private boolean multipleFlg;
    private int printOrder;
    
    public OptionQuestionDTO() {
        
        super();
        this.setPrintOrder(OptionQuestionDTO.ORDER_DEFAULT);
    }

    public boolean isMultipleFlg() {
        return multipleFlg;
    }

    public void setMultipleFlg(boolean multipleFlg) {
        this.multipleFlg = multipleFlg;
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
        return QuestionTypes.MCQ;
    }
}
