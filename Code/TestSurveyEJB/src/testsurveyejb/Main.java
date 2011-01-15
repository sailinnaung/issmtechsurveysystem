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
        
        numSuccess += TestRoleFacade.launchTest();
        numSuccess += TestUserFacade.launchTest();
        numSuccess += TestResearcherSurveyFacade.launchTest();
        
        System.out.println ("TEST COMPLETED. SUCCESS " + numSuccess);
    }
}
