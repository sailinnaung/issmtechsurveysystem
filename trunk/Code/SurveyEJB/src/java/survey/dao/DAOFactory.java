/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import survey.dao.hibernate.RoleDAOImpl;

/**
 *
 * @author A0065956N
 */
public class DAOFactory {

    public static RoleDAO getRoleDAO() {
        
        return new RoleDAOImpl();
    }
}
