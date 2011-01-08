/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author A0065956N
 */
public class SurveyPageDTO implements Serializable {

    private int pageNo;
    private String title;
    private String description;
    private ActivityTypes state;
    private ArrayList<QuestionDTO> questions;
    
    public SurveyPageDTO() {
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionDTO> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ActivityTypes getState() {
        return state;
    }

    public void setState(ActivityTypes state) {
        this.state = state;
    }
}
