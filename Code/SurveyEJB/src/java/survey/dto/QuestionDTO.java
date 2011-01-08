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
public abstract class QuestionDTO implements Serializable {

    protected int questionID;
    protected String code;
    protected String text;
    protected String description;
    protected ActivityTypes state;
    protected QuestionTypes questionType;
    protected boolean mandatoryFlg;
    protected int order;
    
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
    
    public ActivityTypes getState() {
        return state;
    }
    
    public void setState(ActivityTypes state) {
        this.state = state;
    }

    protected QuestionTypes getQuestionType() {
        return questionType;
    }

    protected void setQuestionType(QuestionTypes questionType) {
        this.questionType = questionType;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isMandatory() {
        return mandatoryFlg;
    }

    public void setMandatory(boolean mandatoryFlg) {
        this.mandatoryFlg = mandatoryFlg;
    }
}
