/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import survey.delegates.ResearcherSurveyDelegate;
import survey.dto.ActivityTypes;
import survey.dto.RoleDTO;
import survey.dto.SurveyDTO;
import survey.dto.UserDTO;
import survey.exception.NoLoginException;
import survey.model.SurveyModel;

/**
 *
 * @author Sai Lin Naung
 */

public class QuestionnaireAction extends SurveyActionSupport implements
        Preparable, ModelDriven<SurveyModel> {

    public static final String questionnaire_List = "QuestionnaireList";
    public static final String questionnaire_New = "QuestionnaireNewForm";
    public static final String questionnaire_Update = "QuestionnaireUpdate";
    
    private SurveyModel model = new SurveyModel();
    private UserDTO usrObj;
    private String surveyID;
    private SurveyDTO surveyObj;
    private ArrayList<SurveyDTO> recentEditList = new ArrayList<SurveyDTO>();
    private ArrayList<SurveyDTO> recentSubmitList = new ArrayList<SurveyDTO>();
        

    public QuestionnaireAction() {   }

    public String openQuestionnaireList() throws Exception
    {
//        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
//        recentEditList = rshrDelegate.findSurveysByState(usrObj.getUsername(), ActivityTypes.DRAFT);
//        recentSubmitList = rshrDelegate.findSurveysByState(usrObj.getUsername(), ActivityTypes.SUBMIT);
//
        model.setSurveyEditList(getRecentEditList());
        model.setSurveySubmitList(getRecentSubmitList());
               
        System.out.println("inside questionnaire Lobby before return action String");

        return questionnaire_List;
    }

    public String newQuestionnaire() throws Exception
    {
        return questionnaire_New;
    }

    public String updateQuestionniare() throws Exception
    {
        

        return questionnaire_Update;
    }   
    
    public String deleteQuestionnaire() throws Exception
    {
        return questionnaire_Update;
    }

    public SurveyModel getModel() {
        return model;
    }
    
    public void prepare() throws Exception {
        super.prepare();
        System.out.println("inside QuestionnaireAction prepare");
        usrObj = (UserDTO)session.get(SurveyActionSupport.USER);

//        if(usrObj==null){
//            throw new NoLoginException("User not log in yet.");
//        }
//        System.out.println("User is not null.");
//        RoleDTO rDto = usrObj.getRole();

//        if(rDto.getName().equalsIgnoreCase("researcher")){
//            ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
//            recentEditList = rshrDelegate.findSurveysByState(usrObj.getUsername(), ActivityTypes.DRAFT);
//            recentSubmitList = rshrDelegate.findSurveysByState(usrObj.getUsername(), ActivityTypes.SUBMIT);
//
//            model.setSurveyEditList(recentEditList);
//            model.setSurveySubmitList(recentSubmitList);
//        }
    }

    /**
     * @return the surveyID
     */
    public String getSurveyID() {
        return surveyID;
    }

    /**
     * @param surveyID the surveyID to set
     */
    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    /**
     * @return the surveyObj
     */
    public SurveyDTO getSurveyObj() {
        return surveyObj;
    }

    /**
     * @param surveyObj the surveyObj to set
     */
    public void setSurveyObj(SurveyDTO surveyObj) {
        this.surveyObj = surveyObj;
    }

    public ArrayList<SurveyDTO> getRecentEditList() {
        return recentEditList;
    }

    public ArrayList<SurveyDTO> getRecentSubmitList() {
        return recentSubmitList;
    }

}