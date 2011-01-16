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
public class SurveyReportDTO implements java.io.Serializable {

    private SurveyDTO survey;
    private int numResponses;
    private ArrayList<QuestionReportDTO> items;

    public ArrayList<QuestionReportDTO> getItems() {
        return items;
    }

    public void setItems(ArrayList<QuestionReportDTO> items) {
        this.items = items;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }
}
