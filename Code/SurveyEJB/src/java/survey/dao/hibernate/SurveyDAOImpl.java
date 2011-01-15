/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import survey.dao.*;
import survey.dto.*;
import survey.exception.*;

/**
 *
 * @author vivek
 */
public class SurveyDAOImpl extends AbstractDAO implements SurveyDAO {

    public SurveyDAOImpl() {
        
        super();
    }

    public SurveyDTO createSurvey(String username, SurveyDTO survey) {
        
        this.saveOrUpdate(survey);
        return survey;
    }
}
