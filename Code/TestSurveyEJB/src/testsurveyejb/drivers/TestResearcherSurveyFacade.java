/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testsurveyejb.drivers;

import java.util.ArrayList;
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
            
            surveyPage = surveyFacade.createSurveyPage("vivek", 1, surveyPage);
            System.out.println("Survey Page created for surveyID=1, username=vivek. ID:" + surveyPage.getSurveyPageID());
        } catch (Exception ex) {
            
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    private static boolean testCreateQuestion() {
        
        QuestionDTO q = new RatingQuestionDTO();
        RatingQuestionDTO question = (RatingQuestionDTO) q;
        
        question.setCode("RATE2");
        question.setMandatoryFlg(true);
        question.setOrder(1);
        question.setOrientation(OptionQuestionDTO.ORIENTATION_H);
        question.setText("Rate the following again!");
        
        ArrayList<OptionDTO> options = new ArrayList<OptionDTO>();
        
        OptionDTO option1 = new OptionDTO();
        option1.setCode("EXCELLENT");
        option1.setName("Excellent");
        option1.setOrder(0);
        options.add(option1);
        
        OptionDTO option2 = new OptionDTO();
        option2.setCode("VERY_GOOD");
        option2.setName("Very Good");
        option2.setOrder(1);
        options.add(option2);
        
        OptionDTO option3 = new OptionDTO();
        option3.setCode("GOOD");
        option3.setName("Good");
        option3.setOrder(2);
        options.add(option3);
        
        OptionDTO option4 = new OptionDTO();
        option4.setCode("FAIR");
        option4.setName("Fair");
        option4.setOrder(3);
        options.add(option4);
        
        OptionDTO option5 = new OptionDTO();
        option5.setCode("POOR");
        option5.setName("Poor");
        option5.setOrder(4);
        options.add(option5);
        
        question.setOptions(options);
        
        try {
            
            q = surveyFacade.createQuestion("vivek", 1, 1, q);
            System.out.println("Question created with ID: " + q.getQuestionID());
        } catch (Exception ex) {
            
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public static int launchTest() {
        
        int numSuccess = 0;
        
        System.out.println("testCreateSurvey START...");
        if (testCreateSurvey())
            numSuccess++;
        System.out.println("testCreateSurvey END...");
        System.out.println("testCreateSurveyPage START...");
        if (testCreateSurveyPage())
            numSuccess++;
        System.out.println("testCreateSurveyPage END...");
        System.out.println("testCreateQuestion START...");
        if (testCreateQuestion())
            numSuccess++;
        System.out.println("testCreateQuestion END...");
        
        return numSuccess;
    }
}
