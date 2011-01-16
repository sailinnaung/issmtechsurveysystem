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

    private int surveyPageAnswerID;
    private int pageNo;
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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getSurveyPageAnswerID() {
        return surveyPageAnswerID;
    }

    public void setSurveyPageAnswerID(int surveyPageAnswerID) {
        this.surveyPageAnswerID = surveyPageAnswerID;
    }
}
