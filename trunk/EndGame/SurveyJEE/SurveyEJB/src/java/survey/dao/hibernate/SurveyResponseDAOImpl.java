/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import survey.dao.*;
import survey.dto.*;

/**
 *
 * @author A0065956N
 */
public class SurveyResponseDAOImpl extends AbstractDAO implements SurveyResponseDAO {

    public SurveyResponseDAOImpl() {
        
        super();
    }

    public SurveyAnswerDTO checkSurveyResponse(int surveyAnswerID) {
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(SurveyAnswerDTO.class, surveyAnswerID);
        this.endOperation();
        
        return answer;
    }

    public SurveyAnswerDTO checkSurveyResponse(String username, int surveyID) {
        
        String hql = "from SurveyAnswerDTO as s join s.user as u join s.survey as sur " +
                "where u.username = :username and sur.surveyID = :surveyID";
        Query q = this.createQuery(hql)
                .setString("username", username)
                .setInteger("surveyID", surveyID);
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(q);
        this.endOperation();
        
        return answer;
    }

    public SurveyAnswerDTO createSurveyResponse(int surveyID, String username, SurveyAnswerDTO answer) {
        
        SurveyDTO survey = (SurveyDTO) this.find(SurveyDTO.class, surveyID);
        answer.setSurvey(survey);
        
        String hql = "from UserDTO where username = :username";
        Query q = this.createQuery(hql)
                .setString("username", username);
        UserDTO user = (UserDTO) this.find(q);
        answer.setUser(user);
        
        this.saveOrUpdate(answer);
        this.endOperation();
        return answer;
    }

    public boolean deleteSurveyResponse(int surveyAnswerID) {
        
        String hql = "update SurveyAnswerDTO set state = :state where surveyAnswerID = :surveyAnswerID";
        Query q = this.createQuery(hql)
                .setInteger("state", ActivityTypes.INVALID)
                .setInteger("surveyAnswerID", surveyAnswerID);
        this.executeUpdate(q);
        this.endOperation();
        
        return true;
    }

    public SurveyAnswerDTO getSurveyResponse(int surveyAnswerID) {
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(SurveyAnswerDTO.class, surveyAnswerID);
        if (answer != null) {
            
            Hibernate.initialize(answer.getPages());
        }
        
        this.endOperation();
        
        return answer;
    }

    public SurveyAnswerDTO getSurveyResponse(String username, int surveyID) {
        
        String hql = "from SurveyAnswerDTO as s join s.user as u join s.survey as sur " +
                "where u.username = :username and sur.surveyID = :surveyID";
        Query q = this.createQuery(hql)
                .setString("username", username)
                .setInteger("surveyID", surveyID);
        
        SurveyAnswerDTO answer = (SurveyAnswerDTO) this.find(q);
        if (answer != null) {
            
            Hibernate.initialize(answer.getPages());
        }
        
        this.endOperation();
        
        return answer;
    }
    
    public boolean submitSurveyResponse(int surveyAnswerID) {
        
        String hql = "update SurveyAnswerDTO set state = :state where surveyAnswerID = :surveyAnswerID";
        Query q = this.createQuery(hql)
                .setInteger("state", ActivityTypes.SUBMIT)
                .setInteger("surveyAnswerID", surveyAnswerID);
        this.executeUpdate(q);
        this.endOperation();
        
        return true;
    }
    
    public ArrayList<SurveyDTO> getOpenSurveys(int maxRecords) {
        
        String hql = "from SurveyDTO as s " +
                " where not exists ( " +
                " from SurveyAnswerDTO as ans " +
                " where ans.survey = s " +
                " and ans.state <> :state)";
        Query q = this.createQuery(hql)
                .setInteger("state", ActivityTypes.INVALID)
                .setMaxResults(maxRecords);
        
        ArrayList<SurveyDTO> surveys = new ArrayList<SurveyDTO>(this.findList(q));
        this.endOperation();
        
        return surveys;
    }
    
    public ArrayList<SurveyAnswerDTO> findSurveysByState(String username, int state) {
        
        String hql = "from SurveyAnswerDTO as s " +
                " where s.user.username = :username " +
                " and s.state = :state";
        
        Query q = this.createQuery(hql)
                .setInteger("state", state)
                .setString("username", username);
        
        ArrayList<SurveyAnswerDTO> answers = new ArrayList<SurveyAnswerDTO>(this.findList(q));
        this.endOperation();
        
        return answers;
    }
    
    public int calcTotalResponses(int surveyID) {
        
        String hql = "select count(*) numResponses from SurveyAnswerDTO where s.state = :state and surveyID = :surveyID";
        Query q = this.createQuery(hql)
                .setInteger("state", ActivityTypes.CLOSE);
        Object arg = this.find(q);
        Integer intArg = (Integer) arg;
        return intArg;
    }
}
