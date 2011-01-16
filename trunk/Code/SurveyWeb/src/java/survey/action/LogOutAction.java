/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author a0005933L
 */

public class LogOutAction extends SurveyActionSupport {

    public LogOutAction() {  }

    public String logOut() throws Exception {
        System.out.println("inside log out");
        request.getSession().invalidate();
        return Action.SUCCESS;
    }
            

}