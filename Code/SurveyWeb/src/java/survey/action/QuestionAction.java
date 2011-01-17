/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.action;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import survey.model.SurveyModel;

/**
 *
 * @author a0005933L
 */

public class QuestionAction extends SurveyActionSupport implements
        Preparable, ModelDriven<SurveyModel> {
    
    public static final String questionPage_list = "QuestionPageList";
    
    private SurveyModel sModel = new SurveyModel();

    public QuestionAction() {   }

    public String openQuestionPageList()
    {
        
        return questionPage_list;
    }
    
    public String createSurveyPage(){
        
        return "";
    }

    public SurveyModel getModel() {
        return sModel;
    }
    
    public void prepare() throws Exception {
        super.prepare();
        System.out.println("inside QuestionAction prepare");
    }
}