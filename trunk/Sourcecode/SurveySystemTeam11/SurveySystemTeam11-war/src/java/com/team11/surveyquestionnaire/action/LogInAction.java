/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.team11.surveyquestionnaire.action;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author Sai Lin Naung
 */

public class LogInAction extends SurveyActionSupport {

    private String username;
    private String password;

    public LogInAction() {    }

    public String execute() throws Exception {
        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")){ // to change later after DTO created
            return Action.SUCCESS;
        }else{
            return Action.ERROR;
        }
    }

}