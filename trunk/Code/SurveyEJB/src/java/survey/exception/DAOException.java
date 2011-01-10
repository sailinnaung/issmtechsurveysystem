/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.exception;

import java.io.Serializable;

/**
 *
 * @author A0065956N
 */
public class DAOException extends Exception implements Serializable {

    public DAOException() {}
    
    public DAOException(String s) {
        super(s);
    }
    
    public DAOException(Exception e) {
        super(e);
    }
}
