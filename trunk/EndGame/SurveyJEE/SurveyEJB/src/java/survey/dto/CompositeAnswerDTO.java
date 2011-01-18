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
public class CompositeAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private ArrayList<AnswerDTO> answers;
    
    public CompositeAnswerDTO() {
        super();
        answers = new ArrayList<AnswerDTO>();
    }

    public ArrayList<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<AnswerDTO> answers) {
        this.answers = answers;
    }

    public String toAnswerString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
