/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import survey.dao.*;
import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author A0065956N
 */
class UserHelper {

    UserHelper() {
        
    }
    
    UserDTO checkUserExists(String username) throws UserNotFoundException {
        
        UserDAO dao = DAOFactory.getUserDAO();
        UserDTO user = dao.checkUser(username);
        
        if (user == null)
            throw new UserNotFoundException("User not found: " + username);
        
        return user;
    }
}
