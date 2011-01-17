/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import java.util.Calendar;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import survey.utils.*;
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

    public SurveyDTO checkSurvey(int surveyID) {
        
        SurveyDTO survey = null;
        survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        
        this.endOperation();
        
        return survey;
    }
    
    public SurveyDTO getSurvey(int surveyID) {
        
        SurveyDTO survey = null;
        survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        if (survey != null) {
            
            if (survey.getState() != ActivityTypes.INVALID) {
                Hibernate.initialize(survey.getPages());
            }
        }
        
        this.endOperation();
        
        return survey;
    }
    
    public SurveyDTO getSurvey(String code) {
        
        SurveyDTO survey = null;
        String hql = "from SurveyDTO where code = :code";
        Query q = this.createQuery(hql)
                .setString("code", code);
        survey = (SurveyDTO) this.find(q);
        if (survey != null) {
            
            if (survey.getState() != ActivityTypes.INVALID) {
                Hibernate.initialize(survey.getPages());
            }
        }
        
        this.endOperation();
        
        return survey;
    }
    
    public SurveyDTO createSurvey(SurveyDTO survey) {
        
        this.saveOrUpdate(survey);
        this.endOperation();
        
        return survey;
    }
    
    public SurveyDTO updateSurvey(SurveyDTO survey) {
        
        String hql = "update SurveyDTO " +
                        "set description = :description, " +
                             "endDate = :endDate, " +
                             "startDate = :startDate, " +
                             "title = :title, " +
                             "updateDate = :updateDate" +
                      "where surveyID = :surveyID";
        Query q = this.createQuery(hql)
                .setString("description", survey.getDescription())
                .setCalendarDate("endDate", survey.getEndDate())
                .setCalendarDate("startDate", survey.getStartDate())
                .setString("title", survey.getTitle())
                .setCalendar("updateDate", survey.getUpdateDate())
                .setInteger("surveyID", survey.getSurveyID());
        this.executeUpdate(q);
        this.endOperation();
        
        return survey;
    }
    
    public boolean deleteSurvey(int surveyID) {
        
        String hql = "update SurveyDTO " +
                        "set state = :state, " +
                            "updateDate = :updateDate" +
                      "where surveyID = :surveyID";
        Query q = this.createQuery(hql)
                .setInteger("state", ActivityTypes.INVALID)
                .setCalendar("updateDate", Calendar.getInstance())
                .setInteger("surveyID", surveyID);
        this.executeUpdate(q);
        this.endOperation();
        
        return true;
    }
    
    public ArrayList<SurveyDTO> findSurveys(String username, SurveySearchCriteriaDTO criteria) {
        
        String hql = "from SurveyDTO as s join s.owner as u " +
                " where u.username = :username " +
                " and s.description like :description " + 
                " and s.title like :title ";
        
        Query q = this.createQuery(hql)
                .setString("username", username)
                .setString("description", StringHelper.makeContainsSearch(criteria.getKeywords()))
                .setString("title", StringHelper.makeContainsSearch(criteria.getTitle()));
        
        if (criteria.getCreateDateFrom() != null) {
            
            hql += " and s.createDate >= :startDate ";
            q = q.setCalendarDate("startDate", criteria.getCreateDateFrom());
        }
        
        if (criteria.getCreateDateTo() != null) {
            
            hql += " and s.createDate <= :endDate ";
            q = q.setCalendarDate("endDate", criteria.getCreateDateTo());
        }
        
        if (!criteria.isIncludeClosed()) {
            hql += " and s.state <> :closeState ";
            q = q.setInteger("closeState", ActivityTypes.CLOSE);
        }
        
        if (!criteria.isIncludeInvalid()) {
            hql += " and s.state <> :invalidState ";
            q = q.setInteger("invalidState", ActivityTypes.INVALID);
        }
        
        if (criteria.isActive()) {
            hql += " and s.state = :submitState and s.startDate <= :today and (isNull(s.endDate) and s.endDate >= :today)";
            q = q.setInteger("submitState", ActivityTypes.SUBMIT)
                    .setCalendarDate("today", Calendar.getInstance());
        }
        
        ArrayList<SurveyDTO> surveys = new ArrayList<SurveyDTO>(this.findList(q));
        this.endOperation();
        
        return surveys;
    }
    
    public ArrayList<SurveyDTO> findSurveys(String username, int state) {
     
        String hql = "from SurveyDTO sur " +
                " where sur.owner.username = :username " +
                " and sur.state = :state";
        Query q = this.createQuery(hql)
                .setString("username", username)
                .setInteger("state", state);
        
        ArrayList<SurveyDTO> surveys = new ArrayList<SurveyDTO>(this.findList(q));
        this.endOperation();
        
        return surveys;
    }
}
