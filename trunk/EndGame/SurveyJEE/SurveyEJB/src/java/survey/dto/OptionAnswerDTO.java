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
public class OptionAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private List<OptionDTO> options;
    
    public OptionAnswerDTO() {
        
        super();
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<OptionDTO> options) {
        this.options = options;
    }

    public String toAnswerString() {

        String s = "";
        if (options == null)
            return s;

        for (OptionDTO option : options) {

            if (!s.equals(""))
                s += ", ";

            s += option.getOptionID();
        }

        return s;
    }
}
