/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Remote;
import survey.exception.DAOException;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
@Remote
public interface RoleFacadeRemote {

    RoleDTO createRole(RoleDTO role) throws DAOException;

    RoleDTO updateRole(RoleDTO role);

    boolean deleteRoleByID(int roleID);

    boolean deleteRoleByName(String roleName);
    
}
