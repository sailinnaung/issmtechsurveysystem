/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import survey.dao.*;
import survey.dto.*;

/**
 *
 * @author vivek
 */
public class SurveyPageDAOImpl extends AbstractDAO implements SurveyPageDAO {

    private void sortPages(SurveyDTO survey) {
        
        if (survey.getPages() == null)
            return;
        
        Collections.sort(survey.getPages(), new SurveyPageComparator());
    }
    
    public SurveyPageDAOImpl() {
        
        super();
    }

    public SurveyPageDTO checkSurveyPage(int surveyPageID) {
        
        SurveyPageDTO surveyPage = null;
        surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        
        this.endOperation();
        
        return surveyPage;
    }
    
    public SurveyPageDTO getSurveyPage(int surveyPageID) {
    
        SurveyPageDTO surveyPage = null;
        surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        if (surveyPage != null) {
            
            Hibernate.initialize(surveyPage.getQuestions());
            
            if (surveyPage.getQuestions() == null)
                surveyPage.setQuestions(new ArrayList<QuestionDTO>());
            
            List<QuestionDTO> questions = surveyPage.getQuestions();
            for (int i = 0; i < questions.size(); i++) {
                
                QuestionDTO question = questions.get(i);
                if (question.getQuestionType() == QuestionTypes.CHECKBOX_MCQ ||
                        question.getQuestionType() == QuestionTypes.RADIO_MCQ ||
                        question.getQuestionType() == QuestionTypes.RATING) {
                    Hibernate.initialize(((OptionQuestionDTO)question).getOptions());
                }
            }
        }
        
        this.endOperation();
        
        return surveyPage;
    }
    
    public SurveyPageDTO createSurveyPage(int surveyID, SurveyPageDTO surveyPage) {
        
        SurveyDTO survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        if (survey.getPages() == null)
            survey.setPages(new ArrayList<SurveyPageDTO>());
        
        survey.getPages().add(surveyPage);
        this.saveOrUpdate(survey);
        
        return surveyPage;
    }
    
    public SurveyPageDTO updateSurveyPage(int surveyID, SurveyPageDTO surveyPage) {
        
        String hql = "update SurveyPageDTO " +
                        "set description = :description, " +
                             "pageNo = :pageNo, " +
                             "title = :title " +
                      "where surveyPageID = :surveyPageID";
        Query q = this.createQuery(hql)
                .setString("description", surveyPage.getDescription())
                .setInteger("pageNo", surveyPage.getPageNo())
                .setString("title", surveyPage.getTitle())
                .setInteger("surveyPageID", surveyPage.getSurveyPageID());
        this.executeUpdate(q);
        return surveyPage;
    }
    
    public boolean deleteSurveyPage(int surveyPageID) {
        
        SurveyPageDTO surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        this.delete(surveyPage);
        
        return true;
    }
}
