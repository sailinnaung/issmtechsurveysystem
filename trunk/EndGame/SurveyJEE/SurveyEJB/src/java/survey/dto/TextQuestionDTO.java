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
public class TextQuestionDTO extends QuestionDTO implements Serializable {

    private int questionType;
    private boolean multilineFlg;
    private int charsLimit;
    private String defaultText;
    private String restrictions;    // RegEx value
    
    public TextQuestionDTO() {
        
        super();
    }

    public int getCharsLimit() {
        return charsLimit;
    }

    public void setCharsLimit(int charsLimit) {
        this.charsLimit = charsLimit;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    public boolean isMultilineFlg() {
        
        if (this.questionType == QuestionTypes.NUMBER)
            multilineFlg = false;
        return multilineFlg;
    }

    public void setMultilineFlg(boolean multilineFlg) {
        if (this.questionType == QuestionTypes.NUMBER)
            multilineFlg = false;
        this.multilineFlg = multilineFlg;
    }

    public String getRestrictions() {
        if (this.questionType == QuestionTypes.NUMBER)
            restrictions = "[0-9]*";
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        if (this.questionType == QuestionTypes.NUMBER)
            restrictions = "[0-9]*";
        this.restrictions = restrictions;
    }
    
    public int getQuestionType() {
        return questionType;
    }
    
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
        if (this.questionType == QuestionTypes.NUMBER) {
            this.restrictions = "[0-9]*";
            this.multilineFlg = false;
        }
    }
}
