/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import java.util.ArrayList;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public interface UserDAO {

    public UserDTO createUser(UserDTO user);
    public UserDTO updateUser(UserDTO user);
    public boolean deleteUser(int userID);
    public boolean deleteUser(String username);
    public UserDTO getUser(int userID);
    public UserDTO getUser(String username);
    public ArrayList<UserDTO> getUsers();
    public ArrayList<UserDTO> getUsersByRole(int roleID);
    public ArrayList<UserDTO> getUsersByRole(String roleName);
}
