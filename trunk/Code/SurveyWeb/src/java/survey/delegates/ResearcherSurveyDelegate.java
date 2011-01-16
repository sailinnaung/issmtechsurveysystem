/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.delegates;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import survey.bpo.ResearcherSurveyFacadeRemote;
import survey.dto.ActivityTypes;
import survey.dto.QuestionDTO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyPageDTO;
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
    
    public SurveyPageDTO createSurveyPage(String ownerName,int surveyID, SurveyPageDTO surveyPage) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException, 
            InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.createSurveyPage(ownerName, surveyID, surveyPage);
    }
    
    public QuestionDTO createQuestion(String ownerName,int surveyID, int surveyPageID, QuestionDTO questDto) 
            throws UserNotFoundException, OperationFailedException, RecordNotFoundException, 
            InvalidFieldException, UserNotAllowedException
    {
        return rshrFacade.createQuestion(ownerName, surveyID, surveyPageID, questDto);
    }

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state)
            throws DAOException, RemoteException
    {
        return rshrFacade.findSurveysByState(username, state);
    }

    public ArrayList<SurveyDTO> findRecentSurveysByState(String username,int state,int count)
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
