/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vivek
 */
public class OperationFailedException extends Exception {

    public OperationFailedException(String s) {
     
        super(s);
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "OperationFailedException: CONSTRUCT: " + s);
    }
}
