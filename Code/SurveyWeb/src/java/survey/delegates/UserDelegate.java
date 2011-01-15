/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.delegates;

import java.rmi.RemoteException;
import java.util.ArrayList;
import survey.bpo.UserFacadeRemote;
//import survey.dao.DAOException;
import survey.dto.UserDTO;
import survey.exception.DAOException;
import survey.exception.RecordExistsException;
import survey.servicelocator.UserServiceLocator;

/**
 *
 * @author Sai Lin Naung
 */
public class UserDelegate {

    private UserFacadeRemote usrFacade = null;

    public UserDelegate(){
        usrFacade = lookupUserFacadeBean();
    }
    
    private UserFacadeRemote lookupUserFacadeBean(){
        UserServiceLocator usrLocator = UserServiceLocator.getInstance();
        return usrLocator.lookupUserFacade();
    }

    public UserDTO getUserByID(int id) throws DAOException, RemoteException
    {
        return usrFacade.getUserByID(id);
    }

    public UserDTO getUserByUserName(String userName) throws DAOException, RemoteException
    {
        return usrFacade.getUserByUsername(userName);
    }

    public UserDTO createUser(UserDTO usr) throws DAOException, RemoteException, RecordExistsException
    {
        return usrFacade.createUser(usr);
    }

    public boolean deleteUserByID(int userID)
    {
	return usrFacade.deleteUserByID(userID);
    }


    public boolean deleteUserByUsername(String username)
    {
	 return usrFacade.deleteUserByUsername(username);
    }

    public ArrayList<UserDTO> getUsersByRoleID(int roleID)
    {
	return usrFacade.getUsersByRoleID(roleID);
    }


    public ArrayList<UserDTO> getUsersByRoleName(String roleName)
    {
        return usrFacade.getUsersByRoleName(roleName);
    }


    public UserDTO updateUser(UserDTO user)
    {
       return usrFacade.updateUser(user);
    }

}
