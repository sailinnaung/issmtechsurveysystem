/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao;

import survey.dao.hibernate.*;

/**
 *
 * @author A0065956N
 */
public class DAOFactory {

    public static RoleDAO getRoleDAO() {
        
        return new RoleDAOImpl();
    }
    
    public static UserDAO getUserDAO() {
        
        return new UserDAOImpl();
    }
    
    public static SurveyDAO getSurveyDAO() {
        
        return new SurveyDAOImpl();
    }
    
    public static SurveyPageDAO getSurveyPageDAO() {
        
        return new SurveyPageDAOImpl();
    }
    
    public static SurveyQuestionDAO getSurveyQuestionDAO() {
        
        return new SurveyQuestionDAOImpl();
    }
}
