/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public class TextAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private String value;
    
    public TextAnswerDTO() {
        
        super();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
