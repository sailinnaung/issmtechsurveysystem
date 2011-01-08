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
public class SurveyDTO implements Serializable {

    private int surveyID;
    private UserDTO owner;
    private String title;
    private String description;
    private ActivityTypes state;
    private ArrayList<SurveyPageDTO> pages;
    
    public SurveyDTO() {
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<SurveyPageDTO> getPages() {
        return pages;
    }

    public void setPages(ArrayList<SurveyPageDTO> pages) {
        this.pages = pages;
    }

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
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

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
}
