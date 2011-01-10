/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;

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
       if(getUsername()!=null){
           if(getUsername().equalsIgnoreCase("james") && getPassword().equalsIgnoreCase("password") ){
               System.out.println("@@ before success return");
               return Action.SUCCESS;
           }else{
               System.out.println("@@ before error return");
               return Action.ERROR;
           }
       }else{
           System.out.println("@@ before redirect to log in: username is null");
           return Action.INPUT;
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