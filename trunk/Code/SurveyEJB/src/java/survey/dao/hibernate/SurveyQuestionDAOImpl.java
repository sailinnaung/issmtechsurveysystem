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
public class SurveyQuestionDAOImpl extends AbstractDAO implements SurveyQuestionDAO {

    private void calculateRatings(RatingQuestionDTO question) {
        
        List<OptionDTO> options = question.getOptions();
        if (options != null && options.size() > 0) {
            
            Collections.sort(options, new OptionComparator());
            
            int from = question.getValueFrom();
            int to = question.getValueTo();
            
            if (from == 0 && to == 0) {
                from = 1;
                to = options.size();
            }
            
            float step = (to - from + 1.0F) / (float)options.size();
            float value = from;
            for (OptionDTO option : options) {
                
                option.setValue(value);
                value += step;
            }
        }
    }
    
    public SurveyQuestionDAOImpl() {
        
        super();
    }

    public QuestionDTO checkQuestion(int questionID) {
    
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        this.endOperation();
        
        return question;
    }
    
    public QuestionDTO getQuestion(int questionID) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        if (question != null) {
            if (question.getQuestionType() == QuestionTypes.MCQ ||
                    question.getQuestionType() == QuestionTypes.RATING) {
                
                Hibernate.initialize(question.getOptions());
            }
        }
        
        this.endOperation();
        
        return question;
    }
    
    public QuestionDTO createQuestion(int surveyPageID, QuestionDTO question) {
        
        SurveyPageDTO surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        if (surveyPage.getQuestions() == null)
            surveyPage.setQuestions(new ArrayList<QuestionDTO>());
        
        // calculate range
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings((RatingQuestionDTO) question);
        
        surveyPage.getQuestions().add(question);
        
        this.saveOrUpdate(surveyPage);
        
        return question;
    }
    
    public QuestionDTO updateQuestion(QuestionDTO question) {
        
        String hql = "update QuestionDTO " +
                        "set description = :description, " +
                             "mandatoryFlg = :mandatoryFlg, " +
                             "order = :order, " +
                             "text = :text " +
                      "where questionID = :questionID";
        Query q = this.createQuery(hql)
                .setString("description", question.getDescription())
                .setBoolean("mandatoryFlg", question.isMandatoryFlg())
                .setInteger("order", question.getOrder())
                .setString("text", question.getText())
                .setInteger("questionID", question.getQuestionID());
        this.executeUpdate(q);
        return question;
    }
    
    public boolean deleteQuestion(int questionID) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        this.delete(question);
        return true;
    }
    
    public OptionDTO checkQuestionOption(int optionID) {
        
        OptionDTO option = (OptionDTO) this.find(OptionDTO.class, optionID);
        return option;
    }
    
    public OptionDTO createQuestionOption(int questionID, OptionDTO option)
    {
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        
        if (question.getQuestionType() != QuestionTypes.MCQ 
                && question.getQuestionType() != QuestionTypes.RATING) {
            
            return option;
        }
        
        if (question.getOptions() == null)    
            question.setOptions(new ArrayList<OptionDTO>());
        
        question.getOptions().add(option);
        
        // calculate range
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings((RatingQuestionDTO) question);
        
        // complete
        this.saveOrUpdate(question);
        
        return option;
    }
    
    public OptionDTO updateQuestionOption(int questionID, OptionDTO option) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        Hibernate.initialize(question.getOptions());
        int size = question.getOptions().size();
        for (int i = 0; i < size; i++) {
            
            OptionDTO tmpOption = question.getOptions().get(i);
            if (option.getOptionID() == tmpOption.getOptionID()) {
                question.getOptions().set(i, option);
                break;
            }
        }
        
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings((RatingQuestionDTO) question);
        
        this.saveOrUpdate(question);
        
        return option;
    }
    
    public boolean deleteQuestionOption(int questionID, OptionDTO option) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        Hibernate.initialize(question.getOptions());
        int size = question.getOptions().size();
        for (int i = 0; i < size; i++) {
            
            OptionDTO tmpOption = question.getOptions().get(i);
            if (option.getOptionID() == tmpOption.getOptionID()) {
                question.getOptions().remove(i);
                break;
            }
        }
        
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings((RatingQuestionDTO) question);
        
        this.saveOrUpdate(question);
        
        return true;
    }
}
