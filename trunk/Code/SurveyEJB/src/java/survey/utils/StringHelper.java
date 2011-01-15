/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.utils;

/**
 *
 * @author vivek
 */
public class StringHelper {

    public static boolean checkStringEmpty(String s) {
        
        return (s == null || s.trim().equals(""));
    }
    
    public static String makeContainsSearch(String s) {
        
        return "%" + ((s == null) ? "" : s) + "%";
    }
}
