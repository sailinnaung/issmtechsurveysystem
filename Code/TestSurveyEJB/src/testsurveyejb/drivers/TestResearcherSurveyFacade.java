/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb.drivers;

import java.util.Calendar;
import java.util.Properties;
import javax.naming.InitialContext;
import survey.bpo.*;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public class TestResearcherSurveyFacade {

    private static RoleFacadeRemote roleFacade = null;
    private static UserFacadeRemote userFacade = null;
    private static ResearcherSurveyFacadeRemote surveyFacade = null;
    
    static {
        
        Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        props.put("org.omg.CORBA.ORBInitialPort", "6292");
        try {
            InitialContext ctx = new InitialContext(props);
            roleFacade = (RoleFacadeRemote) ctx.lookup("RoleFacade");
            userFacade = (UserFacadeRemote) ctx.lookup("UserFacade");
            surveyFacade = (ResearcherSurveyFacadeRemote) ctx.lookup("ResearcherSurveyFacade");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static boolean testCreateSurvey() {
        
        SurveyDTO survey = new SurveyDTO();
        survey.setTitle("Blah blah");
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 2);
        survey.setEndDate(endDate);
        
        try {
            
            survey = surveyFacade.createSurvey("vivek", survey);
            System.out.println("Survey created for " + survey.getOwner().getUsername() + " with ID " + survey.getSurveyID());
        } catch (Exception ex) {
            
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testCreateSurveyPage() {
        
        SurveyPageDTO surveyPage = new SurveyPageDTO();
        surveyPage.setPageNo(1);
        surveyPage.setTitle("Something Something Page 1");
        
        try {
            
            surveyPage = surveyFacade.createSurveyPage("vivek", 21, surveyPage);
            System.out.println("Survey Page created for surveyID=1, username=vivek. ID:" + surveyPage.getSurveyPageID());
        } catch (Exception ex) {
            
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static int launchTest() {
        
        int numSuccess = 0;
        
        System.out.println("testCreateSurvey START...");
        if (!testCreateSurvey())
            numSuccess++;
        System.out.println("testCreateSurvey END...");
        System.out.println("testCreateSurveyPage START...");
        if (!testCreateSurveyPage())
            numSuccess++;
        System.out.println("testCreateSurveyPage END...");
        
        return numSuccess;
    }
}
