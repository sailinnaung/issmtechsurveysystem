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
public class OptionQuestionReportDTO extends QuestionReportDTO implements java.io.Serializable {

    private float average;
    private ArrayList<OptionDTO> options;

    public OptionQuestionReportDTO() {
        
        super();
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public ArrayList<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionDTO> options) {
        this.options = options;
    }
}
