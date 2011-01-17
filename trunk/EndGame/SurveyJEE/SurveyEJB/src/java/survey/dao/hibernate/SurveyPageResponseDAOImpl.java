/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import survey.dao.*;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public class SurveyPageResponseDAOImpl extends AbstractDAO implements SurveyPageResponseDAO {

    public SurveyPageResponseDAOImpl() {
        
        super();
    }

    public SurveyPageAnswerDTO checkSurveyPageResponse(int surveyPageAnswerID) {
        
        SurveyPageAnswerDTO answer = (SurveyPageAnswerDTO) this.find(SurveyPageAnswerDTO.class, surveyPageAnswerID);
        return answer;
    }

    public SurveyPageAnswerDTO createSurveyPageResponse(int surveyAnswerID, int surveyPageID, SurveyPageAnswerDTO pageAnswer) {
        
        SurveyPageDTO surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        pageAnswer.setPage(surveyPage);
        pageAnswer.setPageNo(surveyPage.getPageNo());
        
        // In the pageAnswer, make sure that the answers are filled up.
        if (pageAnswer.getAnswers() == null)
            pageAnswer.setAnswers(new ArrayList<AnswerDTO>());
        
        for (AnswerDTO answer : pageAnswer.getAnswers()) {
            if (answer instanceof OptionAnswerDTO) {
                
                OptionAnswerDTO optionAns = (OptionAnswerDTO) answer;
                if (optionAns.getOptions() == null)
                    continue;
                
                List<OptionDTO> options = optionAns.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    
                    OptionDTO option = options.get(i);
                    OptionDTO tmpOption = (OptionDTO) this.find(OptionDTO.class, option.getOptionID());
                    options.set(i, tmpOption);
                }
            }
        }
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(SurveyAnswerDTO.class, surveyAnswerID);
        if (answer.getPages() == null)
            answer.setPages(new ArrayList<SurveyPageAnswerDTO>());
        
        answer.getPages().add(pageAnswer);
        this.saveOrUpdate(answer);
        this.endOperation();
        
        return pageAnswer;
    }

    public SurveyPageAnswerDTO getSurveyPageResponse(int surveyPageAnswerID) {
        
        SurveyPageAnswerDTO pageAnswer = (SurveyPageAnswerDTO) this.find(SurveyPageAnswerDTO.class, surveyPageAnswerID);
        if (pageAnswer != null) {
            
            Hibernate.initialize(pageAnswer.getAnswers());
        }
        
        return pageAnswer;
    }

    public SurveyPageAnswerDTO updateSurveyPageResponse(int surveyPageID, SurveyPageAnswerDTO pageAnswer) {
        
        SurveyPageDTO surveyPage = (SurveyPageDTO) this.find(SurveyPageDTO.class, surveyPageID);
        pageAnswer.setPage(surveyPage);
        
        this.saveOrUpdate(pageAnswer);
        this.endOperation();
        
        return pageAnswer;
    }
}
