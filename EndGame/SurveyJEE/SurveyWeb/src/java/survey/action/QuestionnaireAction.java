/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;
import survey.config.SurveyActionConstants;
import survey.delegates.ResearcherSurveyDelegate;
import survey.dto.ActivityTypes;
import survey.dto.SurveyDTO;
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
    private String surveyCode;    
    private List<SurveyDTO> recentEditList = new ArrayList<SurveyDTO>();
    private List<SurveyDTO> recentSubmitList = new ArrayList<SurveyDTO>();
    private String submitBtn;
           

    public QuestionnaireAction() {   }

    public String openQuestionnaireList() throws Exception
    {
        System.out.println("inside openQuestionnaireList, user name is "+usrObj.getUsername());
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        recentEditList = rshrDelegate.findRecentSurveysByState(usrObj.getUsername(), ActivityTypes.DRAFT,SurveyActionConstants.recent_questionnaire_count);
        recentSubmitList = rshrDelegate.findRecentSurveysByState(usrObj.getUsername(), ActivityTypes.SUBMIT,SurveyActionConstants.recent_questionnaire_count);

        System.out.println("inside questionnaire Lobby before return action String");

        return SurveyActionConstants.questionnaire_List;
    }

    public String newQuestionnaire() throws Exception
    {
        System.out.println("inside newQuestionnaire");
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        if(getSurveyCode()!=null){
            if(!getSurveyCode().equals("new"))
            {
                model.setCurrentSurvey(rshrDelegate.getSurvey(usrObj.getUsername(), getSurveyCode()));
                
                return SurveyActionConstants.questionnaire_New;
            }
            System.out.println("inside getSurveyCode "+getSurveyCode());            
        }
        
        return SurveyActionConstants.questionnaire_New;
    }
    
    public String submitQuestionniare() throws Exception
    {
        System.out.println("inside submit Questionnaire");
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        System.out.println("Selected survey code "+getSurveyCode());
        
        SurveyDTO surveyObj = rshrDelegate.getSurvey(usrObj.getUsername(), getSurveyCode());
        surveyObj.setState(ActivityTypes.SUBMIT);
                
        model.setCurrentSurvey(rshrDelegate.updateSurvey(usrObj.getUsername(), surveyObj));
        
        return openQuestionnaireList();
    }
    
    public String createQuestionniare() throws Exception
    {
        
            System.out.println("inside create");
            ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
            System.out.println("Survey Model survey ID "+model.getCurrentSurvey().getSurveyID());
            System.out.println("Survey Model survey Title "+model.getCurrentSurvey().getTitle());
            System.out.println("Survey Model survey Descriptioin "+model.getCurrentSurvey().getDescription());
            System.out.println("Survey Model start date "+model.getCurrentSurvey().getStartDate());
            System.out.println("Survey Model end date "+model.getCurrentSurvey().getEndDate());
            
            System.out.println("isQuestionnaireUpdate "+isQuestionnaireUpdate());

            if(isQuestionnaireUpdate()){
                model.setCurrentSurvey(rshrDelegate.updateSurvey(usrObj.getUsername(), model.getCurrentSurvey()));
                return SurveyActionConstants.questionPage_list;
            }else{
                model.setCurrentSurvey(rshrDelegate.createSurvey(usrObj.getUsername(), model.getCurrentSurvey()));
                return SurveyActionConstants.questionPage_list;
            }        
    }
    
    public String updateQuestionniare() throws Exception
    { 
        System.out.println("inside updateQuestionnaire");
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        System.out.println("Selected survey code "+getSurveyCode());
        
        SurveyDTO surveyObj = rshrDelegate.getSurvey(usrObj.getUsername(), getSurveyCode());                
        model.setCurrentSurvey(surveyObj);

        setCurrentSurveyDto(surveyObj);
        setQuestionnaireUpdate(true);

        System.out.println("survey object ID :"+surveyObj.getSurveyID());
        
        return SurveyActionConstants.questionnaire_New;
    }
    
    public String deleteQuestionnaire() throws Exception
    {
        System.out.println("inside deleteQuestionnaire");
        ResearcherSurveyDelegate rshrDelegate = new ResearcherSurveyDelegate();
        System.out.println("Selected survey code "+getSurveyCode());
        
        SurveyDTO surveyObj = rshrDelegate.getSurvey(usrObj.getUsername(), getSurveyCode());
        //surveyObj.setState(ActivityTypes.SUBMIT);

        rshrDelegate.deleteSurvey(usrObj.getUsername(), surveyObj.getSurveyID());
        model.setCurrentSurvey(surveyObj);
        //model.setCurrentSurvey(rshrDelegate.updateSurvey(usrObj.getUsername(), surveyObj));
        
        return openQuestionnaireList();
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

        SurveyDTO surDto = (SurveyDTO)session.get(SurveyActionSupport.CURRENT_SURVEY);
        if(surDto!=null){
            model.setCurrentSurvey(surDto);
        }
    }

    /**
     * @return the surveyID
     */
    public String getSurveyCode() {
        return surveyCode;
    }

    /**
     * @param surveyID the surveyID to set
     */
    public void setSurveyCode(String surveyCode) {
        this.surveyCode = surveyCode;
    }



    public List<SurveyDTO> getRecentEditList() {
        return recentEditList;
    }

    public List<SurveyDTO> getRecentSubmitList() {
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