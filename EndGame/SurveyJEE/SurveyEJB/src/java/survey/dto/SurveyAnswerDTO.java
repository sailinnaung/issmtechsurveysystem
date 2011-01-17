/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.util.List;

/**
 *
 * @author A0065956N
 */
public class SurveyAnswerDTO implements java.io.Serializable {

    private int surveyAnswerID;
    private SurveyDTO survey;
    private UserDTO user;
    private List<SurveyPageAnswerDTO> pages;
    private int state;
    
    public SurveyAnswerDTO() {
        
    }

    public List<SurveyPageAnswerDTO> getPages() {
        return pages;
    }

    public void setPages(List<SurveyPageAnswerDTO> pages) {
        this.pages = pages;
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public int getSurveyAnswerID() {
        return surveyAnswerID;
    }

    public void setSurveyAnswerID(int surveyAnswerID) {
        this.surveyAnswerID = surveyAnswerID;
    }
}
