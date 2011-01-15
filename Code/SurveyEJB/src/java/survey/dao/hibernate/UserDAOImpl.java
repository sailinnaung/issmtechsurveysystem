/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import survey.dao.UserDAO;
import survey.dto.*;
import survey.exception.DAOException;

/**
 *
 * @author vivek
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    public UserDAOImpl() {
        super();
    }
    
    public UserDTO createUser(UserDTO user) {
        
        this.saveOrUpdate(user);
        return user;
    }

    public boolean deleteUser(int userID) {
        
        String hql = "update RoleDTO set deleteFlg = true where userID = :userID";
        Query q = this.createQuery(hql).setInteger("userID", userID);
        this.executeUpdate(q);
        
        return true;
    }

    public boolean deleteUser(String username) {
        
        String hql = "update RoleDTO set deleteFlg = true where username = :username and deleteFlg = false";
        Query q = this.createQuery(hql).setString("username", username);
        this.executeUpdate(q);
        
        return true;
    }

    public UserDTO getUser(int userID) {
        
        UserDTO user = null;
        user = (UserDTO) this.find(UserDTO.class, userID);
        if (user != null) {
            Hibernate.initialize(user.getRole());
            Hibernate.initialize(user.getRole().getFunctions());
        }
        
        this.endOperation();
        
        return user;
    }

    public UserDTO getUser(String username) {
        
        UserDTO user = null;
        String hql = "from UserDTO where username = :username and deleteFlg = false";
        
        Query q = this.createQuery(hql).setString("username", username);
        
        user = (UserDTO) this.find(q);
        
        if (user != null) {
            Hibernate.initialize(user.getRole());
            Hibernate.initialize(user.getRole().getFunctions());
        }
        
        this.endOperation();
        
        return user;
    }

    public ArrayList<UserDTO> getUsers() {
        
        ArrayList<UserDTO> users = null;
        String hql = "from UserDTO where deleteFlg = false";
        
        Query q = this.createQuery(hql);
        
        users = new ArrayList<UserDTO>(this.findList(q));
        
        if (users != null) {
            for (UserDTO user : users) {
                
                Hibernate.initialize(user.getRole());
                Hibernate.initialize(user.getRole().getFunctions());
            }
        }
        
        this.endOperation();
        
        return users;
    }

    public ArrayList<UserDTO> getUsersByRole(int roleID) {
        
        ArrayList<UserDTO> users = null;
        String hql = "from UserDTO as u join u.role as r where r.roleID = :roleID";
        
        Query q = this.createQuery(hql).setInteger("roleID", roleID);
        
        users = new ArrayList<UserDTO>(this.findList(q));
        
        if (users != null) {
            for (UserDTO user : users) {
                Hibernate.initialize(user.getRole());
                Hibernate.initialize(user.getRole().getFunctions());
            }
        }
        
        this.endOperation();
        
        return users;
    }

    public ArrayList<UserDTO> getUsersByRole(String roleName) {
        
        ArrayList<UserDTO> users = null;
        String hql = "from UserDTO as u join u.role as r where r.name = :roleName and u.deleteFlg = false";
        
        Query q = this.createQuery(hql).setString("roleName", roleName);
        
        users = new ArrayList<UserDTO>(this.findList(q));
        
        if (users != null) {
            for (UserDTO user : users) {
                Hibernate.initialize(user.getRole());
                Hibernate.initialize(user.getRole().getFunctions());
            }
        }
        
        this.endOperation();
        
        return users;
    }

    public UserDTO updateUser(UserDTO user) {
        
        //this.saveOrUpdate(user);
        String hql = "update UserDTO " +
                        "set password = :password, " +
                            "email = :email, " +
                         "fullName = :fullName, " +
                             "role = :role " +
                      "where userID = :userID";
        Query q = this.createQuery(hql)
                .setString("password", user.getPassword())
                .setString("email", user.getEmail())
                .setString("fullName", user.getFullName())
                .setEntity("role", user.getRole())
                .setInteger("userID", user.getUserID());
        this.executeUpdate(q);
        
        return user;
    }
}
