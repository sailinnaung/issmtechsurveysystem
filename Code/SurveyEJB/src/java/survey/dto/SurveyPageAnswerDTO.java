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
public class SurveyPageAnswerDTO implements java.io.Serializable {

    private SurveyPageDTO page;
    private ArrayList<AnswerDTO> answers;
    
    public SurveyPageAnswerDTO() {
        
        answers = new ArrayList<AnswerDTO>();
    }

    public ArrayList<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<AnswerDTO> answers) {
        this.answers = answers;
    }

    public SurveyPageDTO getPage() {
        return page;
    }

    public void setPage(SurveyPageDTO page) {
        this.page = page;
    }
}
