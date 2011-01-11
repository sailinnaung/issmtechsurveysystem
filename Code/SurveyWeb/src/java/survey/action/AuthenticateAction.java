/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;
import java.rmi.RemoteException;
import survey.config.SurveyActionConstants;
import survey.delegates.UserDelegate;
import survey.dto.UserDTO;
import survey.exception.NoLoginException;

/**
 *
 * @author saimaylinmon
 */

public class AuthenticateAction extends SurveyActionSupport {

    private String username;
    private String password;

    public AuthenticateAction() {  }

    public String execute() throws Exception {
       // below implemenation is for testing purpose only, later will have to change
       System.out.println("inside AuthenticateAction");
       System.out.println("username="+getUsername());

       try{
           if(getUsername()== null || getPassword()==null){
               throw new NoLoginException("User has not logged in.");
           }

           UserDelegate usrD = new UserDelegate();
           //for current testing only
           if(getUsername().equals("Researcher") && getPassword().equals("password"))
               return SurveyActionConstants.Reseacher_Recent_List;

           if(getUsername().equals("Respondant") && getPassword().equals("password"))
               return SurveyActionConstants.Respondant_Recent_List;

           //for current testing only - end here
       }catch (NoLoginException ne) {
		addActionError(getText("error.login.mismatch"));
		return SurveyActionConstants.Failure;
       }catch (Exception e){
           return SurveyActionConstants.Failure;
       }
       return SurveyActionConstants.Failure;
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