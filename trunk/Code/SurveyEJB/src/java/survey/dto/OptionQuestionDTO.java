/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author A0065956N
 */
public class OptionQuestionDTO extends QuestionDTO implements Serializable {

    public static final int ORIENTATION_H = 0;
    public static final int ORIENTATION_V = 1;
    public static final int ORDER_DEFAULT = 0;
    public static final int ORDER_RESPONSES = 1;
    
    private ArrayList<OptionDTO> options;
    private int orientation;
    private boolean multipleFlg;
    private int printOrder;
    
    public OptionQuestionDTO() {
        
        super();
        this.setQuestionType(QuestionTypes.MCQ);
        this.setPrintOrder(OptionQuestionDTO.ORDER_DEFAULT);
    }

    public boolean isMultiple() {
        return multipleFlg;
    }

    public void setMultiple(boolean multipleFlg) {
        this.multipleFlg = multipleFlg;
    }

    public ArrayList<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionDTO> options) {
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
}
