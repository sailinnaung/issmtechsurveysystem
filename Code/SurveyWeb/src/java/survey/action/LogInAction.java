/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;



/**
 *
 * @author Sai Lin Naung
 */

public class LogInAction {

    private String username;
    private String password;

    public LogInAction() {    }

    public String execute() throws Exception {
       System.out.println("inside LogInAction");
       System.out.println("username="+username);
       return "success";
    }

}