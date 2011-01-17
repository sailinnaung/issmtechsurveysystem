/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.List;
import javax.resource.NotSupportedException;

/**
 *
 * @author A0065956N
 */
public abstract class QuestionDTO implements Serializable {

    protected int questionID;
    protected String code;
    protected String text;
    protected String description;
    protected int state;
    //protected int questionType;
    protected boolean mandatoryFlg;
    protected int order;
    protected QuestionDTO parent;   // Used for composite questions.
    
    public QuestionDTO() {
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    public abstract int getQuestionType();

    public void setQuestionType(int questionType) {
        return;
    }
    
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isMandatoryFlg() {
        return mandatoryFlg;
    }

    public void setMandatoryFlg(boolean mandatoryFlg) {
        this.mandatoryFlg = mandatoryFlg;
    }

    public QuestionDTO getParent() {
        return parent;
    }

    public void setParent(QuestionDTO parent) {
        this.parent = parent;
    }
}
