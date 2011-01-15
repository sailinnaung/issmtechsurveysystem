/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.Iterator;
import survey.config.SurveyActionConstants;
import survey.delegates.UserDelegate;
import survey.dto.FunctionDTO;
import survey.dto.RoleDTO;
import survey.dto.UserDTO;
import survey.exception.NoLoginException;
import survey.exception.NoRoleAssignException;
import survey.exception.UserNotFoundException;
import survey.mockDataForTesting.MockDataInterface;

/**
 *
 * @author Sai Lin Naung
 */

public class AuthenticateAction extends SurveyActionSupport
{

    private String username;
    private String password;

    public AuthenticateAction() {  }

    public String execute() throws Exception {
       
       System.out.println("inside AuthenticateAction");
       System.out.println("username="+getUsername());
       System.out.println("password="+getPassword());

       try{
           if(getUsername()== null || getPassword()==null){
               throw new NoLoginException("User has not logged in.");
           }

//           UserDelegate usrD = new UserDelegate();
//           UserDTO usr = usrD.getUserByUserName(getUsername());

           //When binding with bean below part will be taken out
           MockDataInterface mdi = new MockDataInterface();
           UserDTO usr = mdi.getUserByUserName(getUsername());
           // end here

           System.out.println("usr object is null :"+(usr==null));

           if(usr==null){
               throw new UserNotFoundException("User not found");
           }
           setUserObj(usr);
           RoleDTO roleOfUser = usr.getRole();

           if(roleOfUser==null){
               throw new NoRoleAssignException("There is no role for this user "+usr.getUsername());
           }

           addFunctions(roleOfUser.getName(), roleOfUser.getFunctions());
           setFunctions();

           System.out.println("Before return Action Success");
           return "success";

       }catch (NoLoginException ne) {
           System.out.println("inside NoLoginException");
		addActionError(getText("error.login.mismatch"));
		return SurveyActionConstants.Failure;
       }catch (UserNotFoundException ue){
           System.out.println("inside UserNotFoundException "+ue.getMessage());
           return SurveyActionConstants.Failure;
       }catch (NoRoleAssignException re){
           System.out.println("inside NoRoleAssignException "+re.getMessage());
           return SurveyActionConstants.Failure;
       }catch (Exception e){
           System.out.println("inside Exception "+e.getMessage());
           e.printStackTrace();
           return SurveyActionConstants.Failure;
       }       
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}