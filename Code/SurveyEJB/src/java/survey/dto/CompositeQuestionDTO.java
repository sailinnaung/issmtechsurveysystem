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
public class CompositeQuestionDTO extends QuestionDTO implements java.io.Serializable {

    private int compositeType;
    private ArrayList<QuestionDTO> questions;
    
    public CompositeQuestionDTO() {
        
        super();
    }

    public int getCompositeType() {
        return compositeType;
    }

    public void setCompositeType(int compositeType) {
        this.compositeType = compositeType;
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionDTO> questions) {
        this.questions = questions;
    }
    
    public int getQuestionType() {
        return QuestionTypes.COMPOSITE;
    }
}
