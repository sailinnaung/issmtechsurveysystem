/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author vivek
 */
public class UserDTO implements Serializable {

    private String username;
    private String password;
    private String email;
    private boolean deleteFlg;
    private ArrayList<UserRoleDTO> roles;
    
    public UserDTO() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return deleteFlg;
    }

    public void setDeleted(boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<UserRoleDTO> roles) {
        this.roles = roles;
    }
}
