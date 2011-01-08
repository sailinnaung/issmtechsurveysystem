/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;

/**
 *
 * @author A0065956N
 */
public class NumberRangeDTO implements Serializable {

    private int from;
    private int to;
    
    public NumberRangeDTO() {
        
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
