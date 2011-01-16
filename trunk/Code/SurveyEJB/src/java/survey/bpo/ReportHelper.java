/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.ArrayList;
import java.util.List;
import survey.dto.*;
import survey.dao.*;
import survey.exception.*;

/**
 *
 * @author A0065956N
 */
public class ReportHelper {

    public SurveyReportDTO makeReport(int surveyID) throws RecordNotFoundException {
        
        SurveyReportDTO report = new SurveyReportDTO();
        
        // Get the Survey
        SurveyDAO surveyDAO = DAOFactory.getSurveyDAO();
        SurveyDTO survey = surveyDAO.getSurvey(surveyID);
        if (survey == null)
            throw new RecordNotFoundException("Survey not found");
        
        report.setSurvey(survey);
        
        // Get the responses
        SurveyResponseDAO responseDAO = DAOFactory.getSurveyResponseDAO();
        report.setNumResponses(responseDAO.calcTotalResponses(surveyID));
        
        // Traverse through the pages and get the survey answers for questions
        SurveyPageDAO pageDAO = DAOFactory.getSurveyPageDAO();
        List<SurveyPageDTO> pages = survey.getPages();
        for (SurveyPageDTO page : pages) {
            
            page = pageDAO.getSurveyPage(page.getSurveyPageID());
            List<QuestionDTO> questions = page.getQuestions();
            SurveyQuestionDAO questionDAO = DAOFactory.getSurveyQuestionDAO();
            for (QuestionDTO question : questions) {
                
                int questionID = question.getQuestionID();
                int questionType = question.getQuestionType();
                if (questionType == QuestionTypes.RATING ||
                        questionType == QuestionTypes.CHECKBOX_MCQ ||
                        questionType == QuestionTypes.RADIO_MCQ) {
                    
                    ArrayList<OptionReportDTO> options = questionDAO.getReportStats(question.getQuestionID());
                }
            }
        }
        
        return report;
    }
}
