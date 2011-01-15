/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import survey.dao.RoleDAO;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public class RoleDAOImpl extends AbstractDAO implements RoleDAO {

    public RoleDAOImpl() {
        super();
    }
    
    public RoleDTO createRole(RoleDTO role) {
        
        this.saveOrUpdate(role);
        return role;
    }

    public boolean deleteRole(int roleID) {
        
        this.delete(roleID);
        return true;
    }

    public boolean deleteRole(String roleName) {
        
        String hql = "delete from RoleDTO where roleName = :roleName";
        Query q = this.createQuery(hql).setString("roleName", roleName);
        this.executeUpdate(q);
        
        return true;
    }

    public RoleDTO getRole(int roleID) {
        
        RoleDTO role = null;
        role = (RoleDTO) this.find(RoleDTO.class, roleID);
        if (role != null)
            Hibernate.initialize(role.getFunctions());    // to combat lazy fetching
        this.endOperation();
        
        return role;
    }

    public RoleDTO getRole(String roleName) {
        
        RoleDTO role = null;
        String hql = "from RoleDTO where name = :roleName";
        
        Query q = this.createQuery(hql).setString("roleName", roleName);
        
        role = (RoleDTO) this.find(q);
        
        if (role != null)
            Hibernate.initialize(role.getFunctions());    // to combat lazy fetching
        
        this.endOperation();
        
        return role;
    }

    public RoleDTO updateRole(RoleDTO role) {
        
        //this.saveOrUpdate(role);  // This has a cascade problem
        String hql = "update RoleDTO " +
                        "set description = :description " +
                      "where roleID = :roleID";
        Query q = this.createQuery(hql)
                .setString("description", role.getDescription())
                .setInteger("roleID", role.getRoleID());
        this.executeUpdate(q);
        
        return role;
    }

    public ArrayList<RoleDTO> getRoles() {
        
        ArrayList<RoleDTO> roles = null;
        String hql = "from RoleDTO";
        
        Query q = this.createQuery(hql);
        roles = new ArrayList<RoleDTO>(this.findList(q));
        
        if (roles != null) {
            for (RoleDTO role : roles) {
                Hibernate.initialize(role.getFunctions());    // to combat lazy fetching
            }
        }
        
        this.endOperation();
        
        return roles;
    }
}
