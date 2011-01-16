/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.delegates;

import java.rmi.RemoteException;
import java.util.ArrayList;
import survey.bpo.RoleFacadeRemote;
import survey.dto.RoleDTO;
import survey.exception.DAOException;
import survey.exception.RecordExistsException;
import survey.servicelocator.RoleServiceLocator;

/**
 *
 * @author a0005933L
 */
public class RoleDelegate {

    private RoleFacadeRemote roleFacade = null;
    
    public RoleDelegate(){
        roleFacade  = lookupRoleFacadeBean();
    }
    
    private RoleFacadeRemote lookupRoleFacadeBean(){
        RoleServiceLocator roleLocator = RoleServiceLocator.getInstance();
        return roleLocator.loopupRoleFacade();
    }
    
    public RoleDTO getRoleByName(String name)throws DAOException, RemoteException
    {
        return roleFacade.getRoleByName(name);
    }
    
    public RoleDTO createRole(RoleDTO rDto) throws DAOException, RemoteException, RecordExistsException
    {
        return roleFacade.createRole(rDto);
    }
    
    public RoleDTO getRoleByID(int id) throws DAOException, RemoteException
    {
        return roleFacade.getRoleByID(id);
    }
    
    public ArrayList<RoleDTO> getRoles()
    {
        return roleFacade.getRoles();
    }
    
}
