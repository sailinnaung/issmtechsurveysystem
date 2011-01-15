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
import survey.dto.SurveyDTO;
import survey.exception.DAOException;
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

    

    public ArrayList<SurveyDTO> findSurveysByState(String username, int state)
            throws DAOException, RemoteException
    {
        return rshrFacade.findSurveysByState(username, state);
    }

    public ArrayList<SurveyDTO> findRecentSurveyByState(String username,int state,int count)
        throws DAOException, RemoteException
    {
        ArrayList<SurveyDTO> allListByState = rshrFacade.findSurveysByState(username, state);
        ArrayList<SurveyDTO> recentListByState = new ArrayList<SurveyDTO>();

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
