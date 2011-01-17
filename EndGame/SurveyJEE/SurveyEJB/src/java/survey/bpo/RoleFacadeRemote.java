/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Remote;
import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author A0065956N
 */
@Remote
public interface RoleFacadeRemote {

    RoleDTO createRole(RoleDTO role) throws RecordExistsException;

    RoleDTO updateRole(RoleDTO role);

    boolean deleteRoleByID(int roleID);

    boolean deleteRoleByName(String roleName);

    RoleDTO getRoleByID(int roleID);

    RoleDTO getRoleByName(String roleName);

    ArrayList<RoleDTO> getRoles();
    
}
