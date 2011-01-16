/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
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
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(SurveyAnswerDTO.class, surveyAnswerID);
        if (answer.getPages() == null)
            answer.setPages(new ArrayList<SurveyPageAnswerDTO>());
        
        answer.getPages().add(pageAnswer);
        this.saveOrUpdate(answer);
        
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
        return pageAnswer;
    }
}
