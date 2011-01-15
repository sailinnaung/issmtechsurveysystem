/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.servicelocator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import survey.bpo.ResearcherSurveyFacadeRemote;
import survey.config.LookUpConfig;

/**
 *
 * @author Sai Lin Naung
 */
public class ResearcherServiceLocator {

    private InitialContext initCtx = null;
    private static ResearcherServiceLocator locator = null;

    static{
        locator = new ResearcherServiceLocator();
    }

    private ResearcherServiceLocator(){
        try{
            initCtx = new InitialContext();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ResearcherServiceLocator getInstance(){
        return locator;
    }

    public ResearcherSurveyFacadeRemote lookupResearcherSurveyFacade(){
        ResearcherSurveyFacadeRemote rshrFR = null;
        try{
            rshrFR =(ResearcherSurveyFacadeRemote)initCtx.lookup(LookUpConfig.ResearcherSurveyFacadeLookUp);
        }catch(NamingException ne){
            ne.printStackTrace();
        }
        return rshrFR;
    }
}
