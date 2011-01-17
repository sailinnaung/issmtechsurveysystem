/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.config;

/**
 *
 * @author Sai Lin Naung
 */
public interface SurveyActionConstants {
    
    //Struts result name
    public static final String Failure = "failure";
 
    public static final String Admin_Home = "admin";
    public static final String Researcher_Home = "researcher";
    public static final String Respondent_Home = "respondent";
    public static final String Add_New_User = "NewUserForm";
    
    
    //Left Menu Code Mapping
    public static final String FIND_USER_CODE= "FNDUSR";
    public static final String RSH_HOME_CODE= "RSHRHM";
    public static final String RSP_HOME_CODE= "RSPDHM";
    public static final String EDT_PROFILE_CODE= "EDTPRF";
    public static final String NEW_USER_CODE= "NEWUSR";
    public static final String SEARCH_SURVEY_CODE= "SRHSUR";
    public static final String CREATE_SURVEY_CODE= "CRTSUR";
   
    //Questionnaire Related
    public static final String questionnaire_List = "QuestionnaireList";
    public static final String questionnaire_New = "QuestionnaireNewForm";    
    public static final String questionPage_list = "QuestionPageList";
    public static final int recent_questionnaire_count = 10;
    
    //Search
    public static final String find_users = "FindUsers";

}
