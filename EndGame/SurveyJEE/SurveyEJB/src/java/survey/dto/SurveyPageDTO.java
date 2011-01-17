/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author A0065956N
 */
public class SurveyPageDTO implements Serializable {

    private int surveyPageID;
    private int pageNo;
    private String title;
    private String description;
    private int state;
    private List<QuestionDTO> questions;
    
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

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSurveyPageID() {
        return surveyPageID;
    }

    public void setSurveyPageID(int surveyPageID) {
        this.surveyPageID = surveyPageID;
    }
}
