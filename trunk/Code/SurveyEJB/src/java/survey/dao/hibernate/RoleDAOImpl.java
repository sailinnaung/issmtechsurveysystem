/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import survey.dao.DAOException;
import survey.dao.RoleDAO;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public class RoleDAOImpl implements RoleDAO {

    public RoleDAOImpl() {
        super();
    }
    
    public RoleDTO createRole(RoleDTO role) throws DAOException {
        
        Session session = null;
        
        try {
            session = HibernateUtil.openSession();
            HibernateUtil.beginTransaction(session);
            
            session.saveOrUpdate(role);

            if (role.getFunctions() != null) {

                ArrayList<FunctionDTO> functions = role.getFunctions();
                for (FunctionDTO function : functions) {

                    session.saveOrUpdate(function);
                }
            }
            
            HibernateUtil.commitTransaction();
        } catch (Exception ex) {
            
            HibernateUtil.handleException(ex);
        }
        
        if (session != null)
            session.close();
        
        return role;
    }

    public boolean deleteRole(int roleID) throws DAOException {
        
        Session session = null;
        
        try {
            session = HibernateUtil.openSession();
            HibernateUtil.beginTransaction(session);
            
            String hql = "delete from RoleDTO where roleID = :roleID";
            Query q = session.createQuery(hql)
                    .setInteger("roleID", roleID);
            q.executeUpdate();
            
            HibernateUtil.commitTransaction();
        } catch (Exception ex) {
            
            HibernateUtil.handleException(ex);
        }
        
        if (session != null)
            session.close();
        
        return true;
    }

    public boolean deleteRole(String roleName) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RoleDTO getRole(int roleID) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RoleDTO getRole(String roleName) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RoleDTO updateRole(RoleDTO role) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
