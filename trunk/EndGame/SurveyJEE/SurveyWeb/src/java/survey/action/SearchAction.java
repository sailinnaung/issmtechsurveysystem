/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import survey.config.SurveyActionConstants;
import survey.delegates.RoleDelegate;
import survey.delegates.UserDelegate;
import survey.dto.RoleDTO;
import survey.dto.SurveyDTO;
import survey.dto.SurveySearchCriteriaDTO;
import survey.dto.UserDTO;
import survey.exception.DAOException;

/**
 *
 * @author a0005933L
 */

public class SearchAction extends SurveyActionSupport {

    private String fullName;
    private String type;
    private String roleName;
    private SurveySearchCriteriaDTO searchCriteria;
    private List<SurveyDTO> searchResult;
    private List<UserDTO> userList;
    private List<RoleDTO> roles;
    
    public SearchAction() {    }
    
    public String openFindUser() throws DAOException, RemoteException
    {
        RoleDelegate roleDel = new RoleDelegate();
        setRoles(roleDel.getRoles());
        
        return SurveyActionConstants.find_users;
    }
    
    public String searchUsers() throws DAOException, RemoteException
    {
        UserDelegate usrDel = new UserDelegate();
        userList = new ArrayList<UserDTO>();                
        System.out.println("inside search Users, fullName "+fullName);
        if(type.equalsIgnoreCase("fullname")&& fullName!=null){
            userList.add(usrDel.getUserByUserName(fullName));
        }else if(roleName!=null)
        {            
            userList = usrDel.getUsersByRoleName(roleName);
        }
        return SurveyActionConstants.find_users;
    }
    
    public List<SurveyDTO> searchSurveys()
    {
        return searchResult;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public SurveySearchCriteriaDTO getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(SurveySearchCriteriaDTO searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<SurveyDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<SurveyDTO> searchResult) {
        this.searchResult = searchResult;
    }

    public List<UserDTO> getUersList() {
        return userList;
    }

    public void setUersList(List<UserDTO> uersList) {
        this.userList = uersList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RoleDTO> getRoles() {
        if (roles == null)
            roles = new ArrayList<RoleDTO>();
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    
    
}