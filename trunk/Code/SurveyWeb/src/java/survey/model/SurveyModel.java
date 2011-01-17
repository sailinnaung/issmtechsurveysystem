/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.model;

import java.util.ArrayList;
import java.util.List;
import survey.dto.QuestionDTO;
import survey.dto.SurveyDTO;
import survey.dto.SurveyPageDTO;

/**
 *
 * @author Sai Lin Naung
 */
public class SurveyModel {

    private List<SurveyPageDTO> surveyPageList = new ArrayList<SurveyPageDTO>();
    private List<QuestionDTO> questionList = new ArrayList<QuestionDTO>();
    private SurveyDTO currentSurvey;

       /**
     * @return the surveyPageList
     */
    public List<SurveyPageDTO> getSurveyPageList() {
        return surveyPageList;
    }

    /**
     * @param surveyPageList the surveyPageList to set
     */
    public void setSurveyPageList(List<SurveyPageDTO> surveyPageList) {
        this.surveyPageList = surveyPageList;
    }

    /**
     * @return the questionList
     */
    public List<QuestionDTO> getQuestionList() {
        return questionList;
    }

    /**
     * @param questionList the questionList to set
     */
    public void setQuestionList(List<QuestionDTO> questionList) {
        this.questionList = questionList;
    }

    /**
     * @return the currentSurvey
     */
    public SurveyDTO getCurrentSurvey() {
        return currentSurvey;
    }

    /**
     * @param currentSurvey the currentSurvey to set
     */
    public void setCurrentSurvey(SurveyDTO currentSurvey) {
        this.currentSurvey = currentSurvey;
    }
    

}
