/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import java.util.Calendar;
import survey.dao.*;
import survey.dto.*;
import survey.exception.*;
import survey.utils.*;

/**
 *
 * @author Vivek
 */
class SurveyHelper {

    SurveyHelper() {
        
    }
    
    SurveyDTO checkSurveyExists(int surveyID) throws SurveyNotFoundException {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        // Check if this is a valid survey
        SurveyDTO survey = dao.checkSurvey(surveyID);
        if (survey == null)
            throw new SurveyNotFoundException("Survey not found");
        
        return survey;
    }
    
    boolean checkSurveyFields(SurveyDTO survey) throws InvalidFieldException {
        
        // Check if title is empty
        if (StringHelper.checkStringEmpty(survey.getTitle()))
            throw new InvalidFieldException("Survey title is empty");
        
        // Check if the start and end date are correct
        if (survey.getStartDate() == null)
            survey.setStartDate(Calendar.getInstance());
        
        Calendar startDate = DateHelper.removeTimestamp(survey.getStartDate());
        Calendar endDate = DateHelper.removeTimestamp(survey.getEndDate());
        if (startDate != null)
            DateHelper.removeTimestamp(startDate);
        
        if (endDate != null)
            DateHelper.removeTimestamp(endDate);
        
        if (!DateHelper.checkDateRange(startDate, endDate))
            throw new InvalidFieldException("The end date is not greater than the start date");
        
        // Check if the start date is today or later
        if (DateHelper.checkDateBeforeToday(startDate))
            throw new InvalidFieldException("The start date is before today");
        
        return true;
    }
}
