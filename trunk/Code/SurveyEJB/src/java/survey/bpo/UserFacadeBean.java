/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import javax.ejb.Stateless;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
@Stateless
public class UserFacadeBean implements UserFacadeRemote {

    public UserDTO createUser(UserDTO user) {
        return null;
    }

    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    public boolean deleteUserByID(int userID) {
        return false;
    }

    public boolean deleteUserByUsername(String username) {
        return false;
    }

    public UserDTO getUserByID(int userID) {
        return null;
    }
    
    public UserDTO getUserByUsername(String username) {
        return null;
    }
    
    public UserDTO addRole(int userID, RoleDTO role) {
        return null;
    }

    public UserDTO removeRole(int userID, RoleDTO role) {
        return null;
    }
}
