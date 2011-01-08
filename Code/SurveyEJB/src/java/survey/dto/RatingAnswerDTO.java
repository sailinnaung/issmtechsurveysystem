/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public class RatingAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private OptionDTO option;
    
    public RatingAnswerDTO() {
        
        super();
    }

    public OptionDTO getOption() {
        return option;
    }

    public void setOption(OptionDTO option) {
        this.option = option;
    }
}
