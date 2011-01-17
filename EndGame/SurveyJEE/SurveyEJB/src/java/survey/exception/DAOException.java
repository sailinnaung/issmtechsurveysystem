/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.exception;

/**
 *
 * @author A0065956N
 */
public class DAOException extends RuntimeException {

    public DAOException() {}
    
    public DAOException(String s) {
        super(s);
    }
    
    public DAOException(Exception e) {
        super(e);
    }
}
