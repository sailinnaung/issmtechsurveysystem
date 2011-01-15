/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.bpo;

import survey.dao.*;
import survey.dto.*;
import survey.exception.*;
import survey.utils.*;

/**
 *
 * @author A0065956N
 */
class SurveyPageHelper {

    SurveyPageHelper() {
        
    }
    
    SurveyPageDTO checkSurveyPageExists(int surveyPageID) throws SurveyNotFoundException {
        
        SurveyDAO dao = DAOFactory.getSurveyDAO();
        // Check if this is a valid survey
        SurveyPageDTO surveyPage = dao.checkSurveyPage(surveyPageID);
        if (surveyPage == null)
            throw new SurveyNotFoundException("Survey Page not found");
        
        return surveyPage;
    }
    
    boolean checkFields(SurveyPageDTO surveyPage) throws InvalidFieldException {
        
        if (StringHelper.checkStringEmpty(surveyPage.getTitle()))
            throw new InvalidFieldException("The title is mandatory");
        
        return true;
    }
}
