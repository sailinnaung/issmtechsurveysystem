/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Stateless;
import survey.exception.DAOException;
import survey.dao.DAOFactory;
import survey.dao.*;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
@Stateless(mappedName="RoleFacade")
public class RoleFacadeBean implements RoleFacadeRemote {

    public RoleDTO createRole(RoleDTO role) throws DAOException {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        try {
            role = dao.createRole(role);
            
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw ex;
        }
        
        return role;
    }

    public RoleDTO updateRole(RoleDTO role) {
        return null;
    }

    public boolean deleteRoleByID(int roleID) {
        
        RoleDAO dao = DAOFactory.getRoleDAO();
        try {
            return dao.deleteRole(roleID);
            
        } catch (DAOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    public boolean deleteRoleByName(String roleName) {
        return false;
    }
}
