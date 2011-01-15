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
    
    private static boolean testCreateUser() {
        
        if (userFacade == null || roleFacade == null)
            return false;
        
        UserDTO user = new UserDTO();
        user.setUsername("vivek");
        user.setPassword("password");
        
        RoleDTO role = roleFacade.getRoleByName("ADMIN1");
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
    
    public static boolean launchTest() {
        
        if (!testCreateUser())
            return false;
        
        return true;
    }
}
