/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

/**
 *
 * @author A0065956N
 */
public class DAOException extends Exception {

    public DAOException() {}
    
    public DAOException(String s) {
        super(s);
    }
    
    public DAOException(Exception e) {
        super(e);
    }
}
