/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import survey.exception.DAOException;
import survey.dao.*;
import survey.dto.*;
import survey.exception.RecordExistsException;

/**
 *
 * @author A0065956N
 */
@Stateless(mappedName="RoleFacade")
public class RoleFacadeBean implements RoleFacadeRemote {

    public RoleDTO createRole(RoleDTO role) throws RecordExistsException {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        
        // Check if the role exists by name
        RoleDTO tmpRole = dao.getRole(role.getName());
        if (tmpRole != null)
            throw new RecordExistsException("Role already exists for name=" + tmpRole.getName());
        
        return dao.createRole(role);
    }

    public RoleDTO updateRole(RoleDTO role) throws DAOException {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.updateRole(role);
    }

    public boolean deleteRoleByID(int roleID) {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.deleteRole(roleID);
    }

    public boolean deleteRoleByName(String roleName) {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.deleteRole(roleName);
    }

    public RoleDTO getRoleByID(int roleID) {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.getRole(roleID);
    }

    public RoleDTO getRoleByName(String roleName) {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.getRole(roleName);
    }

    public ArrayList<RoleDTO> getRoles() {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        return dao.getRoles();
    }
}
