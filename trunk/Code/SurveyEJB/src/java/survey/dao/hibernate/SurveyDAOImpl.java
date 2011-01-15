/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import survey.dao.*;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public class SurveyDAOImpl extends AbstractDAO implements SurveyDAO {

    public SurveyDAOImpl() {
        
        super();
    }

    public SurveyDTO getSurvey(int surveyID) {
        
        SurveyDTO survey = null;
        survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        if (survey != null) {
            
            Hibernate.initialize(survey.getOwner());
            Hibernate.initialize(survey.getPages());
            
            if (survey.getPages() == null)
                survey.setPages(new ArrayList<SurveyPageDTO>());
        }
        
        this.endOperation();
        
        return survey;
    }
    
    public SurveyDTO createSurvey(SurveyDTO survey) {
        
        this.saveOrUpdate(survey);
        
        return survey;
    }
    
    public SurveyPageDTO getSurveyPage(int surveyPageID) {
    
        SurveyPageDTO surveyPage = null;
        surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        if (surveyPage != null) {
            
            Hibernate.initialize(surveyPage.getQuestions());
            
            if (surveyPage.getQuestions() == null)
                surveyPage.setQuestions(new ArrayList<QuestionDTO>());
        }
        
        this.endOperation();
        
        return surveyPage;
    }
    
    public SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage) {
        
        SurveyDTO survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        survey.getPages().add(surveyPage);
        this.saveOrUpdate(survey);
        
        return surveyPage;
    }
}
