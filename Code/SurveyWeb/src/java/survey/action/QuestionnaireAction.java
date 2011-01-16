/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import survey.config.SurveyActionConstants;
import survey.delegates.ResearcherSurveyDelegate;
import survey.dto.ActivityTypes;
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
    
      
    private SurveyModel model = new SurveyModel();
    private UserDTO usrObj;
    private String surveyID;
    private SurveyDTO surveyObj;
    private ArrayList<SurveyDTO> recentEditList = new ArrayList<SurveyDTO>();
    private ArrayList<SurveyDTO> recentSubmitList = new ArrayList<SurveyDTO>();
    private String submitBtn;
        

    public QuestionnaireAction() {   }

    public String openQuestionnaireList() throws Exception
    {
        System.out.println("inside openQuestionnaireList, user name is "+usrObj.getUsername());
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        recentEditList = rshrDelegate.findRecentSurveysByState(usrObj.getUsername(), ActivityTypes.DRAFT,SurveyActionConstants.recent_questionnaire_count);
        recentSubmitList = rshrDelegate.findRecentSurveysByState(usrObj.getUsername(), ActivityTypes.SUBMIT,SurveyActionConstants.recent_questionnaire_count);

        System.out.println("setting model object");
        
        model.setSurveyEditList(getRecentEditList());
        model.setSurveySubmitList(getRecentSubmitList());
               
        System.out.println("inside questionnaire Lobby before return action String");

        return SurveyActionConstants.questionnaire_List;
    }

    public String newQuestionnaire() throws Exception
    {
        return SurveyActionConstants.questionnaire_New;
    }
    
    public String submitQuestionniare() throws Exception
    {
        if("create".equals(submitBtn)){
            System.out.println("inside create");
            ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
            
            
            return SurveyActionConstants.questionPage_list;
        }else{
            System.out.println("inside submit");
            return SurveyActionConstants.questionnaire_List;
        }
    }   
    
    public String deleteQuestionnaire() throws Exception
    {
        return SurveyActionConstants.questionnaire_List;
    }

    public SurveyModel getModel() {
        return model;
    }
    
    public void prepare() throws Exception {
        super.prepare();
        System.out.println("inside QuestionnaireAction prepare setting user object");
        setUsrObj((UserDTO) session.get(SurveyActionSupport.USER));

        if(usrObj==null){
            throw new NoLoginException("User not log in yet.");
        }
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
        if(surveyObj==null)
            surveyObj = new SurveyDTO();
        return surveyObj;
    }

    /**
     * @param surveyObj the surveyObj to set
     */
    public void setSurveyObj(SurveyDTO surveyObj) {
        if(surveyObj!=null){
            System.out.println("setting surveyObj");
            surveyObj.setSurveyID(Integer.parseInt(surveyID));
            this.surveyObj = surveyObj;
        }else{
            System.out.println("surveyObj is null.");
        }        
    }

    public ArrayList<SurveyDTO> getRecentEditList() {
        return recentEditList;
    }

    public ArrayList<SurveyDTO> getRecentSubmitList() {
        return recentSubmitList;
    }

    public String getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtn(String submitBtn) {
        this.submitBtn = submitBtn;
    }

    public UserDTO getUsrObj() {
        return usrObj;
    }

    public void setUsrObj(UserDTO usrObj) {
        this.usrObj = usrObj;
    }

}