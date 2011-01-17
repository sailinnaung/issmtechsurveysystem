/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.delegates;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import survey.bpo.ResearcherSurveyFacadeRemote;
import survey.dto.OptionDTO;
import survey.dto.QuestionDTO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyPageDTO;
import survey.dto.SurveySearchCriteriaDTO;
import survey.exception.DAOException;
import survey.exception.InvalidFieldException;
import survey.exception.OperationFailedException;
import survey.exception.RecordNotFoundException;
import survey.exception.UserNotAllowedException;
import survey.exception.UserNotFoundException;
import survey.servicelocator.ResearcherServiceLocator;

/**
 *
 * @author Sai Lin Naung
 */
public class ResearcherSurveyDelegate {

    private ResearcherSurveyFacadeRemote rshrFacade = null;

    public ResearcherSurveyDelegate(){
        rshrFacade = lookupResearcherSurveyFacadeBean();
    }

    private ResearcherSurveyFacadeRemote lookupResearcherSurveyFacadeBean(){
        ResearcherServiceLocator rshrLocator = ResearcherServiceLocator.getInstance();
        return rshrLocator.lookupResearcherSurveyFacade();
    }

    public SurveyDTO createSurvey(String ownerName, SurveyDTO survey) throws UserNotFoundException, 
            OperationFailedException, InvalidFieldException
    {
        return rshrFacade.createSurvey(ownerName, survey);
    }
    
    public SurveyDTO updateSurvey(String ownerName,SurveyDTO survey) throws UserNotFoundException, 
            UserNotAllowedException, RecordNotFoundException, InvalidFieldException
    {
        return rshrFacade.updateSurvey(ownerName, survey);
    }
    
    public boolean deleteSurvey(String ownerName,int surveyID) throws UserNotFoundException, 
            UserNotAllowedException, RecordNotFoundException
    {
        return rshrFacade.deleteSurvey(ownerName, surveyID);
    }
    
    public SurveyPageDTO createSurveyPage(String ownerName,int surveyID, SurveyPageDTO surveyPage) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException, 
            InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.createSurveyPage(ownerName, surveyID, surveyPage);
    }
    
    public SurveyPageDTO updateSurveyPage(String ownerName, int surveyID,SurveyPageDTO surveyPage) throws UserNotFoundException, 
            RecordNotFoundException, InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.updateSurveyPage(ownerName, surveyID, surveyPage);
    }
    
    public boolean deleteSurveyPage(String ownerName, int surveyID, int surveyPageID) throws UserNotFoundException, 
            RecordNotFoundException, UserNotAllowedException
    {
        return rshrFacade.deleteSurveyPage(ownerName, surveyID, surveyPageID);
    }
    
    public QuestionDTO createQuestion(String ownerName,int surveyID, int surveyPageID, QuestionDTO questDto) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException, 
            InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.createQuestion(ownerName, surveyID, surveyPageID, questDto);
    }
    
    public QuestionDTO updateQuestin(String ownerName, int surveyID, int surveyPageID, QuestionDTO question) throws UserNotFoundException, 
            RecordNotFoundException, InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.updateQuestion(ownerName, surveyID, surveyPageID, question);
    }
    
    public boolean deleteQuestion(String ownerName,int surveyID, int surveyPageID,int questionID) throws UserNotFoundException, 
            UserNotFoundException, UserNotAllowedException, RecordNotFoundException
    {
        return rshrFacade.deleteQuestion(ownerName, surveyID, surveyPageID, questionID);
    }
    
    public OptionDTO createQuestionOption(String ownerName,int questionID, OptionDTO option) throws UserNotFoundException, 
            OperationFailedException, RecordNotFoundException, InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.createQuestionOption(ownerName, questionID, option);
    }
    
    public OptionDTO updateQuestionOption(String ownerName, int questionID, OptionDTO option) throws UserNotFoundException,
            RecordNotFoundException, InvalidFieldException
    {
        return rshrFacade.updateQuestionOption(ownerName, questionID, option);
    }
    
    public boolean deleteQuestionOption(String ownerName,int questionID, OptionDTO option) throws UserNotFoundException,
            RecordNotFoundException
    {
        return rshrFacade.deleteQuestionOption(ownerName, questionID, option);
    }
    
    public SurveyDTO getSurvey(String ownerName, String surveyCode) throws UserNotFoundException
    {
        return rshrFacade.getSurvey(ownerName, surveyCode);
    }
    
    public SurveyDTO getSurvey(String ownerName,int surveyID) throws UserNotFoundException
    {
        return rshrFacade.getSurvey(ownerName, surveyID);
    }
    
    public ArrayList<SurveyDTO> findSurveys(String ownerName,SurveySearchCriteriaDTO criteria)
    {
        return rshrFacade.findSurveys(ownerName, criteria);
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state)
            throws DAOException, RemoteException
    {
        return rshrFacade.findSurveysByState(username, state);
    }

    public List<SurveyDTO> findRecentSurveysByState(String username,int state,int count)
        throws DAOException, RemoteException
    {
        System.out.println("user name in findRecentSurveyByState is "+username+" and state is "+state);
        
        ArrayList<SurveyDTO> allListByState = rshrFacade.findSurveysByState(username, state);
        ArrayList<SurveyDTO> recentListByState = new ArrayList<SurveyDTO>();
        System.out.println("inside findRecentSurveyByState after retrieving from remote bean.");
        Iterator<SurveyDTO> allListItr = allListByState.iterator();
        int index =1;
        while(allListItr.hasNext()){
            if(index==count){
                break;
            }
            recentListByState.add(allListItr.next());
            index++;
        }

        return recentListByState;
    }
}
