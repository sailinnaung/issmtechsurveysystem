/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Remote;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
@Remote
public interface UserFacadeRemote {

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user);

    boolean deleteUserByID(int userID);

    boolean deleteUserByUsername(String username);

    UserDTO getUserByID(int userID);
    
    UserDTO getUserByUsername(String username);
    
    UserDTO addRole(int userID, RoleDTO role);

    UserDTO removeRole(int userID, RoleDTO role);   
}
