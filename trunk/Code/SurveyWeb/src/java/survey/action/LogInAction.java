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

public class LogInAction extends SurveyActionSupport {

    public LogInAction() {    }

    public String execute() throws Exception {
       System.out.println("inside LogInAction");

       return "success";
    }

}