/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public abstract class AnswerDTO {
    
    private int answerID;
    private QuestionDTO question;   // Must be a clone
    
    public AnswerDTO() {
        
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }
}
