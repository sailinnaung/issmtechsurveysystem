/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import java.util.ArrayList;
import survey.exception.DAOException;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public interface RoleDAO {

    public RoleDTO getRole(int roleID) throws DAOException;
    public RoleDTO getRole(String roleName) throws DAOException;
    public ArrayList<RoleDTO> getRoles() throws DAOException;
    public RoleDTO createRole(RoleDTO role) throws DAOException;
    public RoleDTO updateRole(RoleDTO role) throws DAOException;
    public boolean deleteRole(int roleID) throws DAOException;
    public boolean deleteRole(String roleName) throws DAOException;
}
