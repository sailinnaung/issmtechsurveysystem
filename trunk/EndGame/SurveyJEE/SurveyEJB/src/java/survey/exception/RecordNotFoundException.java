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
public class RecordNotFoundException extends Exception {

    public RecordNotFoundException(String s) {
     
        super(s);
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "SurveyNotFoundException: CONSTRUCT: " + s);
    }
}
