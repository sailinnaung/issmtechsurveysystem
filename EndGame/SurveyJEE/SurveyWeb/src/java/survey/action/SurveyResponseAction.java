/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import survey.config.SurveyActionConstants;
import survey.delegates.ResponseDelegate;
import survey.dto.*;
import survey.exception.RecordNotFoundException;
import survey.exception.UserNotFoundException;

/**
 *
 * @author Mahsa
 */
public class SurveyResponseAction extends SurveyActionSupport {

    ResponseDelegate mgr = new ResponseDelegate();
    private ArrayList<SurveyDTO> draftSurvays = new ArrayList<SurveyDTO>();
    private ArrayList<SurveyDTO> openSurvays = new ArrayList<SurveyDTO>();
    private Integer surveyID = 0;
    private int surveyPageID = 0;
    private SurveyPageDTO surveypage = new SurveyPageDTO();
    private String message = "";
    private String username = "";
    private List<QuestionDTO> questions = new ArrayList<QuestionDTO>();
    private List<AnswerDTO> answers = new ArrayList<AnswerDTO>();
    private Map<Integer, String> names = new HashMap<Integer, String>();
    private SurveyDTO survey = new SurveyDTO();
    private List<AnswerDTO> Answerlist;
    private String Session_SurveyAnswerMap;

    public String openHomePage() {
        username = ((UserDTO) session.get(USER)).getUsername();
        draftSurvays = mgr.findSurveysByState(username, ActivityTypes.DRAFT);
        openSurvays = mgr.findOpenSurveys(100);
        return SurveyActionConstants.Open_Home_Page;

    }

    public String openEditProfile() {

        username = ((UserDTO) session.get(USER)).getUsername();
        return SurveyActionConstants.Open_Edit_Profile;
    }

    public String openSearchQuestioner() {

        username = ((UserDTO) session.get(USER)).getUsername();
        return SurveyActionConstants.Open_Search_Questioner;
    }

    public String openSurveyDescription() {
      
        try {
            if (session == null) {
                session = new HashMap<String, Object>();
            }
            
            username = ((UserDTO) session.get(USER)).getUsername();
            
            session.put(SurveyActionConstants.Session_SurveyID, surveyID);
            survey = mgr.getSurvey(username, surveyID);
            // Get the response related to the survey (if any)
            SurveyAnswerDTO  ans=mgr.getSurveyResponseBySurvey(username, surveyID);
            
            if (ans == null) {
            
                ans = mgr.createSurveyResponse(username, surveyID);
                ans.setPages(null);
            }
            
            if (ans != null) {
                
                session.put(SurveyActionConstants.Session_SurveyAnswerID, ans.getSurveyAnswerID());
                
                // Create the map of SurveyPageID and SurveyPageAnswerID
                HashMap<Integer, Integer> ansMap = new HashMap<Integer, Integer>();
                List<SurveyPageAnswerDTO> pageAnswers = ans.getPages();
                if (pageAnswers != null) {
                    for (SurveyPageAnswerDTO pageAnswer : pageAnswers) {
                        ansMap.put(pageAnswer.getPage().getSurveyPageID(), pageAnswer.getSurveyPageAnswerID());
                    }
                }
                
                session.put(SurveyActionConstants.Session_SurveyPageAnswerMap, ansMap);
            }
            
            if (survey.getPages() == null || survey.getPages().size() == 0) {
                message = "No Question Found";
                throw new Exception(message);
            }
            
            session.put(SurveyActionConstants.Session_CurrentPageID, survey.getPages().get(0).getSurveyPageID());
            List<SurveyPageDTO> pageList = survey.getPages();

            Integer[] pageIDlist = new Integer[pageList.size()];
            for (int i = 0; i < pageList.size(); i++) {

                pageIDlist[i] = pageList.get(i).getSurveyPageID();
            }
            session.put(SurveyActionConstants.Session_pageIDList, pageIDlist);
            SurveyAnswerDTO resp= mgr.getSurveyResponseBySurvey(username,  surveyID);
            
            if(resp!=null)
                session.put(Session_SurveyAnswerMap, resp.getSurveyAnswerID());
           
            return SurveyActionConstants.Open_Servey_Description;
        } catch (Exception e) {

            e.printStackTrace();
            return SurveyActionConstants.Error;
        }
    }

    public String delete() throws UserNotFoundException {
        try {
            username = ((UserDTO) session.get(USER)).getUsername();
            if(session.get(SurveyActionConstants.Session_SurveyAnswerID) != null)
                mgr.deleteResponse(username, (Integer)session.get(SurveyActionConstants.Session_SurveyAnswerID));
        } catch (UserNotFoundException ex) {
            throw ex;
        }
        message = "one Response delete successfully";
        return openHomePage();
    }

//    public String editResponsepage() throws UserNotFoundException {
//
//        System.out.println("START");
//        username = ((UserDTO) session.get(USER)).getUsername();
//        surveyID = (Integer) session.get(SurveyActionConstants.Session_SurveyID);
//        surveyPageID = (Integer) session.get(SurveyActionConstants.Session_CurrentPageID);
//        try {
//            surveypage = mgr.getSurveyPage(username, surveyID, surveyPageID);
//        } catch (RecordNotFoundException ex) {
//            Logger.getLogger(SurveyResponseAction.class.getName()).log(Level.SEVERE, null, ex);
//            return SurveyActionConstants.Error;
//        }
//        questions = (ArrayList<QuestionDTO>) surveypage.getQuestions();
//        SurveyPageAnswerDTO myAnsObject = mgr.getSurveyPageResponse(username, surveyPageID);
//        Answerlist = myAnsObject.getAnswers();
//        
//        return SurveyActionConstants.Open_Response_page;
//
//    }

    public String openResponsepage() {
        
        System.out.println("in openResponsePage");
        try {
            names = new HashMap<Integer, String>();
            
            username = ((UserDTO) session.get(USER)).getUsername();
            surveyID = (Integer) session.get(SurveyActionConstants.Session_SurveyID);
            surveyPageID = (Integer) session.get(SurveyActionConstants.Session_CurrentPageID);
            
            // Get the Survey Page for the questions
            SurveyPageDTO page = mgr.getSurveyPage(username, surveyID, surveyPageID);
            questions = page.getQuestions();
            
            // Get the Survey Page Answer to get all answers
            SurveyPageAnswerDTO pageAnswer = null;
            int pageAnswerID = 0;
            HashMap<Integer, Integer> ansMap = (HashMap<Integer, Integer>) session.get(SurveyActionConstants.Session_SurveyPageAnswerMap);
            if (ansMap != null)
                pageAnswerID = ansMap.get(surveyPageID);
            
            if (pageAnswerID != 0) {
                
                pageAnswer = mgr.getSurveyPageResponse(username, pageAnswerID);
                answers = pageAnswer.getAnswers();
                
                if (answers != null) {
                    
                    for (AnswerDTO answer : answers) {

                      names.put(answer.getQuestion().getQuestionID(), answer.toAnswerString());
                      
                    }
                }
            }   
        } catch (Exception ex) {
        }
        
        return SurveyActionConstants.Open_Response_page;
    }

    public String saveResponsepage() {
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@"+names.get(1));
        System.out.println("@@@@@@@@@@@@@@@@@@@@@"+names.get(2));
           System.out.println("@@@@@@@@@@@@@@@@@@@@@"+names.get(3));

        try {
            username = ((UserDTO) session.get(USER)).getUsername();
            if (session == null) {
                message = "Session is null";
                return ERROR;
            }
            SurveyPageAnswerDTO answerdto = new SurveyPageAnswerDTO();
            answers = new ArrayList<AnswerDTO>();

            ArrayList<String> ansList = new ArrayList<String>(names.values());
            surveyID = (Integer) session.get(SurveyActionConstants.Session_SurveyID);
            surveyPageID = (Integer) session.get(SurveyActionConstants.Session_CurrentPageID);
            surveypage = mgr.getSurveyPage(username, surveyID, surveyPageID);
            questions = (ArrayList<QuestionDTO>) surveypage.getQuestions();
            for (QuestionDTO question : questions) {

                String response = names.get(question.getQuestionID());
                if (question.getQuestionType() == QuestionTypes.CHECKBOX_MCQ) {
                    OptionAnswerDTO ans = new OptionAnswerDTO();
                    String[] resps = response.split(", ");
                    ArrayList<OptionDTO> opts = new ArrayList<OptionDTO>();
                    for (String res : resps) {
                        OptionDTO opt = new OptionDTO();
                        opt.setOptionID(Integer.valueOf(res));
                        opts.add(opt);
                    }
                    ans.setOptions(opts);
                    ans.setQuestion(question);
                    answers.add(ans);

                }
                if (question.getQuestionType() == QuestionTypes.NUMBER) {

                    TextAnswerDTO ans2 = new TextAnswerDTO();
                    String resp = names.get(question.getQuestionID());
                    ans2.setQuestion(question);
                    ans2.setValue(resp);
                    answers.add(ans2);
                }
                if (question.getQuestionType() == QuestionTypes.RADIO_MCQ) {

                    OptionAnswerDTO ans = new OptionAnswerDTO();
                    ArrayList<OptionDTO> opts = new ArrayList<OptionDTO>();
                    OptionDTO opt = new OptionDTO();
                    opt.setOptionID(Integer.valueOf(names.get(question.getQuestionID())));
                    opts.add(opt);
                    ans.setOptions(opts);
                    ans.setQuestion(question);
                    answers.add(ans);

                }
                if (question.getQuestionType() == QuestionTypes.RATING) {

                    TextAnswerDTO ans2 = new TextAnswerDTO();
                    String resp = names.get(question.getQuestionID());
                    ans2.setQuestion(question);
                    ans2.setValue(resp);
                    answers.add(ans2);
                }
                if (question.getQuestionType() == QuestionTypes.TEXT) {

                    TextAnswerDTO ans2 = new TextAnswerDTO();
                    String resp = names.get(question.getQuestionID());
                    ans2.setQuestion(question);
                    ans2.setValue(resp);
                    answers.add(ans2);
                }
            }

            SurveyPageAnswerDTO surveypageResponse = new SurveyPageAnswerDTO();
            surveypageResponse.setAnswers(answers);
            mgr.saveSurveyPageResponse(username, surveyPageID, surveypageResponse);


            //go to the next page
            Integer[] list = (Integer[]) session.get(SurveyActionConstants.Session_pageIDList);
            for (int i = 0; i < list.length - 1; i++) {
                if (surveyPageID == list[i] && i < list.length - 1) {
                    session.put(SurveyActionConstants.Session_CurrentPageID, list[i + 1]);
                    return openResponsepage();
                }
            }
        } catch (Exception e) {
        }
        
        return SurveyActionConstants.Last_Page;
    }

    public String submitSurvey() throws UserNotFoundException {
        username = ((UserDTO) session.get(USER)).getUsername();
        surveyID = (Integer) session.get(SurveyActionConstants.Session_SurveyID);
        mgr.submitResponse(username, surveyID);
        return openHomePage();
    }
///////////////////////////////////////////////////////////////////////

    public Map<Integer, String> getNames() {

        return names;
    }

    public void setNames(Map<Integer, String> options) {
        this.names = options;
    }

    public String test() {

        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyy" + surveyID);
        message = String.valueOf(surveyID);
        return SurveyActionConstants.Error;
    }
    ////////////////////////////////////////////////////////////////

    public ArrayList<SurveyDTO> getOpenSurvays() {
        return openSurvays;
    }

    public void setOpenSurvays(ArrayList<SurveyDTO> openSurvays) {
        this.openSurvays = openSurvays;
    }

    public ArrayList<SurveyDTO> getDraftSurvays() {
        return draftSurvays;
    }

    public void setDraftSurvays(ArrayList<SurveyDTO> draftSurvays) {
        this.draftSurvays = draftSurvays;
    }

    public Integer getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public SurveyPageDTO getSurveypage() {
        return surveypage;
    }

    public void setSurveypage(SurveyPageDTO surveypage) {
        this.surveypage = surveypage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSurveyPageID() {
        return surveyPageID;
    }

    public void setSurveyPageID(Integer surveyPageID) {
        this.surveyPageID = surveyPageID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSession(Map<String, Object> map) {
        this.session = map;

    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public SurveyDTO getSurvey() {
        return survey;
    }

    public void setSurvey(SurveyDTO survey) {
        this.survey = survey;
    }
}
