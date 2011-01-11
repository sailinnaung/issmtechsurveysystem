/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.delegates;

import java.rmi.RemoteException;
import survey.bpo.UserFacadeRemote;
import survey.dao.DAOException;
import survey.dto.UserDTO;
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
        return usrLocator.lookupUserFacadeBean();
    }

    public UserDTO getUserByID(int id) throws DAOException, RemoteException
    {
        return usrFacade.getUserByID(id);
    }

    public UserDTO getUserByUserName(String userName) throws DAOException, RemoteException
    {
        return usrFacade.getUserByUsername(userName);
    }

    // to continue to handle all user related functions below
}
