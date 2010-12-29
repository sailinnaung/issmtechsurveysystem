package com.team11.surveyquestionnaire.action;

import com.opensymphony.xwork2.Action;

/**
 *
 * @author Sai Lin Naung
 */

public class AuthenticateAction extends SurveyActionSupport{



    private String username;
    private String password;

    public AuthenticateAction() {
    }

    @Override
    public String execute() throws Exception {

        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")){ // to change later after DTO created
            return Action.SUCCESS;
        }else{
            return Action.ERROR;
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