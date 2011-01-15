/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import javax.ejb.Stateless;
import survey.dto.*;
import survey.dao.*;
import survey.exception.*;

/**
 *
 * @author A0065956N
 */
@Stateless(mappedName="UserFacade")
public class UserFacadeBean implements UserFacadeRemote {

    public UserDTO createUser(UserDTO user) throws RecordExistsException {
        
        UserDAO dao = DAOFactory.getUserDAO();
        
        // Check if the user exists by username
        UserDTO tmpUser = dao.getUser(user.getUsername());
        if (tmpUser != null)
            throw new RecordExistsException("User already exists for name=" + tmpUser.getUsername());
        
        return dao.createUser(user);
    }

    public UserDTO updateUser(UserDTO user) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        return dao.updateUser(user);
    }

    public boolean deleteUserByID(int userID) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        return dao.deleteUser(userID);
    }

    public boolean deleteUserByUsername(String username) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        return dao.deleteUser(username);
    }

    public UserDTO getUserByID(int userID) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        UserDTO user = dao.getUser(userID);
        user.setPassword("");   // Never pass the password
        
        return user;
    }
    
    public UserDTO getUserByUsername(String username) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        UserDTO user = dao.getUser(username);
        user.setPassword("");   // Never pass the password
        
        return user;
    }

    public ArrayList<UserDTO> getUsers() {
        
        UserDAO dao = DAOFactory.getUserDAO();
        ArrayList<UserDTO> users = dao.getUsers();
        
        // Never pass the password
        for (UserDTO user : users) {
            
            user.setPassword("");
        }
        
        return users;
    }

    public ArrayList<UserDTO> getUsersByRoleID(int roleID) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        ArrayList<UserDTO> users = dao.getUsersByRole(roleID);
        
        // Never pass the password
        for (UserDTO user : users) {
            
            user.setPassword("");
        }
        
        return users;
    }

    public ArrayList<UserDTO> getUsersByRoleName(String roleName) {
        
        UserDAO dao = DAOFactory.getUserDAO();
        ArrayList<UserDTO> users = dao.getUsersByRole(roleName);
        
        // Never pass the password
        for (UserDTO user : users) {
            
            user.setPassword("");
        }
        
        return users;
    }

    public boolean authenticateUser(String username, String password) throws UserNotFoundException {
        
        UserDAO dao = DAOFactory.getUserDAO();
        UserDTO user = dao.getUser(username);
        
        if (user == null)
            throw new UserNotFoundException("User is not found");
        
        if (user.getPassword().equals(password))
            return true;
        
        return false;
    }
}
