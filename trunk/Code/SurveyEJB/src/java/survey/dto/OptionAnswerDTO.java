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
public class OptionAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private ArrayList<OptionDTO> options;
    
    public OptionAnswerDTO() {
        
        super();
        options = new ArrayList<OptionDTO>();
    }

    public ArrayList<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<OptionDTO> options) {
        this.options = options;
    }
}
