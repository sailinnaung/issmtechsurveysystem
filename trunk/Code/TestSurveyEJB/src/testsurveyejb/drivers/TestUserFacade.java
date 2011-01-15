/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb.drivers;

import java.util.Properties;
import javax.naming.InitialContext;
import survey.bpo.*;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public class TestUserFacade {

    private static RoleFacadeRemote roleFacade = null;
    private static UserFacadeRemote userFacade = null;
    
    static {
        
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        props.put("org.omg.CORBA.ORBInitialPort", "6292");
        try {
            InitialContext ctx = new InitialContext(props);
            roleFacade = (RoleFacadeRemote) ctx.lookup("RoleFacade");
            userFacade = (UserFacadeRemote) ctx.lookup("UserFacade");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static boolean testUpdateUser() {
        
        if (userFacade == null || roleFacade == null)
            return false;
        
        UserDTO user = new UserDTO();
        user.setUserID(1);
        user.setUsername("vivek1");
        user.setPassword("password1");
        user.setFullName("Vivek Narayana Shankar");
        user.setRole(roleFacade.getRoleByName("RESPONDENT"));
        
        try {
            user = userFacade.updateUser(user);
            System.out.println("User updated with ID: " + user.getUserID());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testCreateUser() {
        
        if (userFacade == null || roleFacade == null)
            return false;
        
        UserDTO user = new UserDTO();
        user.setUsername("vivek");
        user.setPassword("password");
        user.setFullName("Vivek Shankar");
        
        RoleDTO role = roleFacade.getRoleByName("RESEARCHER");
        user.setRole(role);
        
        try {
            user = userFacade.createUser(user);
            System.out.println("User created with ID: " + user.getUserID());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static int launchTest() {
        
        int totalSuccess = 0;
        
        System.out.println("testCreateUser START...");
        if (testCreateUser())
            totalSuccess++;
        System.out.println("testCreateUser END...");
        System.out.println("testUpdateUser START...");
        if (testUpdateUser())
            totalSuccess++;
        System.out.println("testUpdateUser END...");
        
        return totalSuccess;
    }
}
