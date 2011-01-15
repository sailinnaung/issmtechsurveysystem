/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb.drivers;

import java.util.ArrayList;
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
        
        try {
            {
                RoleDTO role = new RoleDTO();
                role.setDescription("Administrator User");
                role.setName("ADMIN");

                role = facade.createRole(role);
                roleID = role.getRoleID();
                System.out.println("Role created with ID: " + role.getRoleID());
            }
            {
                RoleDTO role = new RoleDTO();
                role.setDescription("Researcher User");
                role.setName("RESEARCHER");

                role = facade.createRole(role);
                roleID = role.getRoleID();
                System.out.println("Role created with ID: " + role.getRoleID());
            }
            {
                RoleDTO role = new RoleDTO();
                role.setDescription("Respondent User");
                role.setName("RESPONDENT");

                role = facade.createRole(role);
                roleID = role.getRoleID();
                System.out.println("Role created with ID: " + role.getRoleID());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testUpdateRole() {
        
        if (facade == null)
            return false;
        
        RoleDTO role = facade.getRoleByName("ADMIN");
        role.setDescription("Admin User");
        role.setFunctions(null);
        try {
            role = facade.updateRole(role);
            System.out.println("Role updated for ID: " + role.getRoleID());
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static int launchTest() {    
        
        int numSuccess = 0;
        
        System.out.println("testCreateRole START...");
        if (!testCreateRole())
            numSuccess++;
        System.out.println("testCreateRole END...");
        System.out.println("testGetRoles START...");
        if (!testGetRoles())
            numSuccess++;
        System.out.println("testGetRoles END...");
        System.out.println("testUpdateRole START...");
        if (!testUpdateRole())
            numSuccess++;
        System.out.println("testUpdateRole END...");
        System.out.println("testGetRoles START...");
        if (!testGetRoles())
            numSuccess++;
        System.out.println("testGetRoles END...");
        
        return numSuccess;
    }
}
