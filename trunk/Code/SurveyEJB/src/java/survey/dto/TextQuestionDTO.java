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
        return multilineFlg;
    }

    public void setMultilineFlg(boolean multilineFlg) {
        this.multilineFlg = multilineFlg;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
    
    public int getQuestionType() {
        return questionType;
    }
    
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
        if (this.questionType == QuestionTypes.NUMBER)
            this.restrictions = "[0-9]*";
    }
}
