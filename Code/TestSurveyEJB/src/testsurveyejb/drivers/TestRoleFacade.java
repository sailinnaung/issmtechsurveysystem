/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb.drivers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import survey.bpo.RoleFacadeRemote;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public class TestRoleFacade {

    private static RoleFacadeRemote facade = null;
    private static int roleID;
    
    static {
        
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        props.put("org.omg.CORBA.ORBInitialPort", "6292");
        try {
            InitialContext ctx = new InitialContext(props);
            facade = (RoleFacadeRemote) ctx.lookup("RoleFacade");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static boolean testGetRoles() {
        
        if (facade == null)
            return false;
        
        try {
            ArrayList<RoleDTO> roles = facade.getRoles();
            for (RoleDTO role : roles) {
                System.out.println("Found role [" + role.getRoleID() + "," + role.getName() + "," + ((role.getFunctions() == null) ? 0 : role.getFunctions().size()) + "]");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testCreateRole() {
        
        if (facade == null)
            return false;
        
        RoleDTO role = new RoleDTO();
        role.setDescription("Administrator User");
        role.setName("ADMIN2");
        
        FunctionDTO function = new FunctionDTO();
        function.setFunctionID(1);
        function.setCode("SEARCH_USERS");
        function.setDescription("Search Users");
        function.setName("Search Users");
        function.setOrder(1);
        
        List<FunctionDTO> functions = new ArrayList<FunctionDTO>();
        functions.add(function);
        
        role.setFunctions(functions);
        
        try {
            role = facade.createRole(role);
            roleID = role.getRoleID();
            System.out.println("Role created with ID: " + role.getRoleID());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testUpdateRole() {
        
        if (facade == null)
            return false;
        
        RoleDTO role = facade.getRoleByName("ADMIN2");
        role.setDescription("Admin User");
        
        try {
            role = facade.updateRole(role);
            System.out.println("Role updated for ID: " + role.getRoleID());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static boolean launchTest() {
        
        
        
        if (!testCreateRole())
            return false;
        
        if (!testGetRoles())
            return false;
       
        if (!testUpdateRole())
            return false;
        
        if (!testGetRoles())
            return false;
        
        return true;
    }
}
