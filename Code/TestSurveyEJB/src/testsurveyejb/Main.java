/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb;

import testsurveyejb.drivers.*;

/**
 *
 * @author vivek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int numSuccess = 0, numTotal = 0;
        if (TestRoleFacade.launchTest())
            numSuccess++;
        
        if (TestUserFacade.launchTest())
            numSuccess++;
        
        numTotal++;
    }
}
