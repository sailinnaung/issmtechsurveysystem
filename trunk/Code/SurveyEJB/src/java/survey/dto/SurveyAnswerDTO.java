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
public class SurveyAnswerDTO {

    private SurveyDTO survey;
    private UserDTO user;
    private ArrayList<SurveyPageDTO> pages;
    private ActivityTypes state;
    
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

    public ActivityTypes getState() {
        return state;
    }

    public void setState(ActivityTypes state) {
        this.state = state;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
