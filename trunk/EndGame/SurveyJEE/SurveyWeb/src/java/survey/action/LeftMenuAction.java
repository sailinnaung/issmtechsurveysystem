/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import survey.config.SurveyActionConstants;
import survey.dto.FunctionDTO;

/**
 *
 * @author a0005933L
 */

public class LeftMenuAction extends SurveyActionSupport implements
        Preparable
{
    private List<FunctionDTO> functionsOfUser;
    private String linkAction;

    public LeftMenuAction() {    }

    public String execute() throws Exception {
        System.out.println("linkAction "+linkAction);
        if(functionsOfUser==null){
            return SurveyActionSupport.ERROR;
        }else{
            if(linkAction==null){
                return SurveyActionSupport.ERROR;
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.FIND_USER_CODE)){
                return SurveyActionConstants.find_users;
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.RSH_HOME_CODE)){
                return SurveyActionConstants.Researcher_Home;
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.EDT_PROFILE_CODE)){
                System.out.println("Not done yet"); return "";
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.NEW_USER_CODE)){
                return SurveyActionConstants.Add_New_User;
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.SEARCH_SURVEY_CODE)){
                System.out.println("Not done yet"); return "";
            }else if(linkAction.equalsIgnoreCase(SurveyActionConstants.CREATE_SURVEY_CODE)){
                return SurveyActionConstants.questionnaire_New;
            }else if (linkAction.equalsIgnoreCase(SurveyActionConstants.RSP_HOME_CODE)) {
                return SurveyActionConstants.Respondent_Home;
            } else{
                return SurveyActionSupport.ERROR;
            }                       
        }        
    }
  
    
    public void prepare() throws Exception {
        super.prepare();
        functionsOfUser =(List<FunctionDTO>) session.get(SurveyActionSupport.FUNCTIONS_USER);
        if(functionsOfUser==null){
            System.out.println("function list is null in session.");
        }
        System.out.println("inside leftMenu Aciton");
    }

    public List<FunctionDTO> getFunctionsOfUser() {
        return functionsOfUser;
    }

    public void setFunctionsOfUser(List<FunctionDTO> functionsOfUser) {
        this.functionsOfUser = functionsOfUser;
    }

    public String getLinkAction() {
        return linkAction;
    }

    public void setLinkAction(String linkAction) {
        this.linkAction = linkAction;
    }

}