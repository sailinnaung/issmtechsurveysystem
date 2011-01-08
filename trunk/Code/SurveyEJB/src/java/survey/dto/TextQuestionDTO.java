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

    protected boolean multilineFlg;
    protected int charsLimit;
    protected String defaultText;
    protected String restrictions;    // RegEx value
    
    public TextQuestionDTO() {
        
        super();
        this.setQuestionType(QuestionTypes.TEXT);
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

    public boolean isMultiline() {
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
}
