/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public class NumberQuestionReportDTO extends QuestionReportDTO implements java.io.Serializable {

    private float average;
    
    public NumberQuestionReportDTO() {
        
        super();
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
