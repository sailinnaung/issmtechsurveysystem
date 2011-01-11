/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.config;

/**
 *
 * @author Sai Lin Naung
 */
public interface LookUpConfig {

   public static final String UserFacadeBeanLookUp = "java:comp/env/bpo/UserFacadeBean";
   public static final String SurveyFacadeBeanLookUp = "java:comp/env/bpo/SurveyFacadeBean";
   public static final String RoleFacadeBeanLookUp = "java:comp/env/bpo/RoleFacadeBean";
}
