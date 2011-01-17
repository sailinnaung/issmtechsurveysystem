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

    private void calculateRatings(OptionQuestionDTO question) {
        
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
            if (question.getQuestionType() == QuestionTypes.CHECKBOX_MCQ ||
                    question.getQuestionType() == QuestionTypes.RADIO_MCQ ||
                    question.getQuestionType() == QuestionTypes.RATING) {
                
                Hibernate.initialize(((OptionQuestionDTO)question).getOptions());
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
            calculateRatings((OptionQuestionDTO) question);
        
        surveyPage.getQuestions().add(question);
        
        this.saveOrUpdate(surveyPage);
        this.endOperation();
        
        return question;
    }
    
    public QuestionDTO updateQuestion(QuestionDTO question) {
        
        // General question update
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
        
        // Child-table update
        if (question.getQuestionType() == QuestionTypes.TEXT ||
                question.getQuestionType() == QuestionTypes.NUMBER) {
            
            TextQuestionDTO textQuestion = (TextQuestionDTO) question;
            hql = "update TextQuestionDTO " +
                   "  set multilineFlg = :multilineFlg, " +
                    "     charsLimit = :charsLimit, " +
                    "     defaultText = :defaultText, " +
                    "     restrictions = :restrictions, " +
                    "     questionType = :questionType " +
                   "where questionID = :questionID";
            
            q = this.createQuery(hql)
                    .setBoolean("multilineFlg", textQuestion.isMultilineFlg())
                    .setInteger("charsLimit", textQuestion.getCharsLimit())
                    .setString("defaultText", textQuestion.getDefaultText())
                    .setString("restrictions", textQuestion.getRestrictions())
                    .setInteger("questionType", textQuestion.getQuestionType())
                    .setInteger("questionID", question.getQuestionID());
            
            this.executeUpdate(q);
        } else if (question.getQuestionType() == QuestionTypes.CHECKBOX_MCQ ||
                question.getQuestionType() == QuestionTypes.RADIO_MCQ ||
                question.getQuestionType() == QuestionTypes.RATING) {
            
            OptionQuestionDTO optionQuestion = (OptionQuestionDTO) question;
            hql = "update OptionQuestionDTO " +
                   "  set orientation = :orientation, " +
                   "      printOrder = :printOrder, " +
                   "      valueFrom = :valueFrom, " +
                   "      valueTo = :valueTo " +
                   "where questionID = :questionID";
            
            q = this.createQuery(hql)
                    .setInteger("orientation", optionQuestion.getOrientation())
                    .setInteger("printOrder", optionQuestion.getPrintOrder())
                    .setInteger("valueFrom", optionQuestion.getValueFrom())
                    .setInteger("valueTo", optionQuestion.getValueTo());
            
            this.executeUpdate(q);
            
            // Recalculate the ratings
            if (question.getQuestionType() == QuestionTypes.RATING) {
                
                calculateRatings(optionQuestion);
                this.saveOrUpdate(optionQuestion);
            }
        }
        
        this.endOperation();
        return question;
    }
    
    public boolean deleteQuestion(int questionID) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        this.delete(question);
        this.endOperation();
        return true;
    }
    
    public OptionDTO checkQuestionOption(int optionID) {
        
        OptionDTO option = (OptionDTO) this.find(OptionDTO.class, optionID);
        return option;
    }
    
    public OptionDTO createQuestionOption(int questionID, OptionDTO option)
    {
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        
        if (question.getQuestionType() != QuestionTypes.CHECKBOX_MCQ &&
                question.getQuestionType() != QuestionTypes.RADIO_MCQ &&
                question.getQuestionType() != QuestionTypes.RATING) {
            
            return option;
        }
        
        OptionQuestionDTO q = (OptionQuestionDTO) question;
        if (q.getOptions() == null)    
            q.setOptions(new ArrayList<OptionDTO>());
        
        q.getOptions().add(option);
        
        // calculate range
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings(q);
        
        // complete
        this.saveOrUpdate(q);
        this.endOperation();
        
        return option;
    }
    
    public OptionDTO updateQuestionOption(int questionID, OptionDTO option) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        
        if (question.getQuestionType() == QuestionTypes.CHECKBOX_MCQ ||
                question.getQuestionType() == QuestionTypes.RADIO_MCQ ||
                question.getQuestionType() == QuestionTypes.RATING) {
            
            OptionQuestionDTO q = (OptionQuestionDTO) question;
            Hibernate.initialize(q.getOptions());
            int size = q.getOptions().size();
            for (int i = 0; i < size; i++) {
            
                OptionDTO tmpOption = q.getOptions().get(i);
                if (option.getOptionID() == tmpOption.getOptionID()) {
                    q.getOptions().set(i, option);
                    break;
                }
            }
        
            if (q.getQuestionType() == QuestionTypes.RATING)
                calculateRatings((OptionQuestionDTO) question);
        }
        
        this.saveOrUpdate(question);
        this.endOperation();
        
        return option;
    }
    
    public boolean deleteQuestionOption(int questionID, OptionDTO option) {
        
        QuestionDTO question = (QuestionDTO) this.find(QuestionDTO.class, questionID);
        if (question.getQuestionType() != QuestionTypes.CHECKBOX_MCQ &&
                question.getQuestionType() != QuestionTypes.RADIO_MCQ &&
                question.getQuestionType() != QuestionTypes.RATING) {
            
            return false;
        }
        
        OptionQuestionDTO q = (OptionQuestionDTO) question;
        Hibernate.initialize(q.getOptions());
        int size = q.getOptions().size();
        for (int i = 0; i < size; i++) {
            
            OptionDTO tmpOption = q.getOptions().get(i);
            if (option.getOptionID() == tmpOption.getOptionID()) {
                q.getOptions().remove(i);
                break;
            }
        }
        
        if (question.getQuestionType() == QuestionTypes.RATING)
            calculateRatings(q);
        
        this.saveOrUpdate(question);
        this.endOperation();
        
        return true;
    }
    
    public ArrayList<OptionReportDTO> getReportStats(int questionID) {
        
        ArrayList<OptionReportDTO> items = new ArrayList<OptionReportDTO>();
        
        
        return items;
    }
}
