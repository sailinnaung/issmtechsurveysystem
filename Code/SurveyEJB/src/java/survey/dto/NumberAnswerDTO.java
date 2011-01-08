/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

/**
 *
 * @author A0065956N
 */
public class NumberAnswerDTO extends AnswerDTO implements java.io.Serializable {

    private int value;
    
    public NumberAnswerDTO() {
        
        super();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
