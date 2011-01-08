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
public class CompositeQuestionDTO extends QuestionDTO {

    private QuestionTypes compositeType;
    private ArrayList<QuestionDTO> questions;
    
    public CompositeQuestionDTO() {
        
        super();
        this.setQuestionType(QuestionTypes.COMPOSITE);
    }

    public QuestionTypes getCompositeType() {
        return compositeType;
    }

    public void setCompositeType(QuestionTypes compositeType) {
        this.compositeType = compositeType;
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionDTO> questions) {
        this.questions = questions;
    }
}
