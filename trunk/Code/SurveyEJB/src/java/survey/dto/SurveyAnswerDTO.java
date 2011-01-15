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
public class SurveyAnswerDTO implements java.io.Serializable {

    private int surveyAnswerID;
    private SurveyDTO survey;
    private UserDTO user;
    private ArrayList<SurveyPageDTO> pages;
    private int state;
    
    public SurveyAnswerDTO() {
        
        pages = new ArrayList<SurveyPageDTO>();
    }

    public ArrayList<SurveyPageDTO> getPages() {
        return pages;
    }

    public void setPages(ArrayList<SurveyPageDTO> pages) {
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
