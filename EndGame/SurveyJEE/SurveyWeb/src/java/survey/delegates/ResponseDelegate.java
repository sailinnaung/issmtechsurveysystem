/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.delegates;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import survey.bpo.RespondentSurveyFacadeRemote;
import survey.dto.ActivityTypes;
import survey.dto.AnswerDTO;
import survey.dto.OptionDTO;
import survey.dto.OptionQuestionDTO;
import survey.dto.QuestionDTO;
import survey.dto.QuestionTypes;
import survey.dto.SurveyAnswerDTO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyPageAnswerDTO;
import survey.dto.SurveyPageDTO;
import survey.dto.SurveySearchCriteriaDTO;
import survey.dto.TextAnswerDTO;
import survey.dto.TextQuestionDTO;
import survey.dto.UserDTO;
import survey.exception.OperationFailedException;
import survey.exception.RecordExistsException;
import survey.exception.RecordNotFoundException;
import survey.exception.UserNotFoundException;

/**
 *
 * @author Mahsa
 */
public class ResponseDelegate {

    private RespondentSurveyFacadeRemote responseFacade;
    private List<SurveyPageDTO> list;

    public ResponseDelegate() {
        responseFacade = lookupRespondentSurveyFacadeBean();
    }

    private RespondentSurveyFacadeRemote lookupRespondentSurveyFacadeBean() {
        try {
            Context c = new InitialContext();
            return (RespondentSurveyFacadeRemote) c.lookup("RespondentSurveyFacade");
        } catch (NamingException ne) {

            throw new RuntimeException(ne);
        }
    }
//>>>>>>>>>>>>>>>>################################ my methods

    public SurveyDTO getSurvey(String username, int surveyID) throws UserNotFoundException, RecordNotFoundException {
        return responseFacade.getSurvey(username, surveyID);
        
    }

    public SurveyPageDTO getSurveyPage(String username, int surveyID, int surveyPageID) throws UserNotFoundException, RecordNotFoundException {
          return responseFacade.getSurveyPage(username, surveyID, surveyPageID);
       

    }

    public SurveyAnswerDTO getSurveryReponse(String username, int surveyAnswerID) throws UserNotFoundException {
       return responseFacade.getSurveyResponse(username, surveyAnswerID);

    }

    public SurveyPageAnswerDTO getSurveyPageResponse(String username, int surveyPageAnswerID) throws UserNotFoundException {
          return responseFacade.getSurveyPageResponse(username, surveyPageAnswerID);
      
    }

    public boolean submitResponse(String username, int surveyID) throws UserNotFoundException {
         return responseFacade.submitResponse(username, surveyID);
   
    }

    public boolean deleteResponse(String username, int surveyID) throws UserNotFoundException {
        return responseFacade.deleteResponse(username, surveyID);


    }

    public ArrayList<SurveyDTO> findOpenSurveys(int maxRecords) {
           return responseFacade.findOpenSurveys(maxRecords);

     
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state) {
        ArrayList<SurveyAnswerDTO> resps = responseFacade.findSurveysByState(username, state);
        if (resps == null)
            resps = new ArrayList<SurveyAnswerDTO>();
        ArrayList<SurveyDTO> surveys=new ArrayList<SurveyDTO>();
        for(SurveyAnswerDTO resp: resps){
            System.out.println("SURVEYID: " + resp.getSurvey().getSurveyID());
            surveys.add(resp.getSurvey());
        }
        
        return surveys;
    }

 

    public SurveyAnswerDTO createSurveyResponse(String username, int surveyPageID) throws UserNotFoundException, OperationFailedException, RecordExistsException {
        return responseFacade.createSurveyResponse(username, surveyPageID);
    }

    public SurveyPageAnswerDTO saveSurveyPageResponse(String username, int surveyPageAnswerID, SurveyPageAnswerDTO surveyPage) {

        try {
            return responseFacade.saveSurveyPageResponse(username, surveyPageAnswerID, surveyPageAnswerID, surveyPage);
        } catch (Exception ex) {
            Logger.getLogger(ResponseDelegate.class.getName()).log(Level.SEVERE, null, ex);
            return surveyPage;
        }
    }

    public SurveyPageAnswerDTO saveSurveyPageResponse(String username, int surveyAnswerID, int surveyPageID, SurveyPageAnswerDTO surveyPage) throws UserNotFoundException, OperationFailedException, RecordNotFoundException {
        return responseFacade.saveSurveyPageResponse(username, surveyAnswerID, surveyPageID, surveyPage);
    }

    public SurveyAnswerDTO getSurveyResponse(String username, int surveyAnswerID) throws UserNotFoundException {
        return responseFacade.getSurveyResponse(username, surveyAnswerID);
    }

    public SurveyAnswerDTO getSurveyResponseBySurvey(String username, int surveyID) throws UserNotFoundException {
        return responseFacade.getSurveyResponseBySurvey(username, surveyID);
    }
}
