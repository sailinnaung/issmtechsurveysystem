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
public interface UserFacadeRemote {

    UserDTO createUser(UserDTO user) throws RecordExistsException;

    UserDTO updateUser(UserDTO user);

    boolean deleteUserByID(int userID);

    boolean deleteUserByUsername(String username);

    UserDTO getUserByID(int userID);
    
    UserDTO getUserByUsername(String username);

    ArrayList<UserDTO> getUsers();

    ArrayList<UserDTO> getUsersByRoleID(int roleID);

    ArrayList<UserDTO> getUsersByRoleName(String roleName);

    boolean authenticateUser(String username, String password) throws UserNotFoundException;
}
