/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author A0065956N
 */
public class UserRoleDTO implements Serializable {

    private int userRoleID;
    private String name;
    private String description;
    private ArrayList<FunctionDTO> functions;
    
    public UserRoleDTO() {
        
        functions = new ArrayList<FunctionDTO>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }

    public ArrayList<FunctionDTO> getFunctions() {
        return functions;
    }

    public void setFunctions(ArrayList<FunctionDTO> functions) {
        this.functions = functions;
    }
}
