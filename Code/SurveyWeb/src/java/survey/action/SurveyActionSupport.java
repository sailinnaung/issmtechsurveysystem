
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import survey.dto.FunctionDTO;
import survey.dto.SurveyDTO;
import survey.dto.UserDTO;



/**
 *
 * @author Sai Lin Naung
 */

public class SurveyActionSupport extends ActionSupport implements
       ServletRequestAware, SessionAware, Preparable {

    public static final String USER = "USER";    
    public static final String FUNCTIONS_USER = "FUNCTIONS_USER";
    public static final String CURRENT_SURVEY = "CURRENT_SURVEY";

    protected HttpServletRequest request;
    protected Map<String, Object> session;

    private SurveyDTO currentSurvey;
    private UserDTO userObj;
    private List<FunctionDTO> functionsOfUser;

    public SurveyActionSupport() {
    }

    //@Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public HttpSession getSession(boolean b) {
        return request.getSession(b);
    }
    
    /**
     * @return the mySurveyDto
     */
    public SurveyDTO getCurrentSurveyDto() {
        return currentSurvey;
    }

    /**
     * @param mySurveyDto the mySurveyDto to set
     */
    public void setCurrentSurveyDto(SurveyDTO mySurveyDto) {
        this.currentSurvey = mySurveyDto;
        session.put(SurveyActionSupport.CURRENT_SURVEY, this.currentSurvey);
    }

    /**
     * @return the userObj
     */
    public UserDTO getUserObj() {
        return userObj;
    }

    /**
     * @param userObj the userObj to set
     */
    public void setUserObj(UserDTO userObj) {
        this.userObj = userObj;
        session.put(SurveyActionSupport.USER, this.userObj);
    }


    public List<FunctionDTO> getFunctions(){
        return (List<FunctionDTO>)session.get(SurveyActionSupport.FUNCTIONS_USER);
    }
   
    public void setFunctions(List<FunctionDTO> funcs){
        this.functionsOfUser = funcs;
        session.put(SurveyActionSupport.FUNCTIONS_USER, this.functionsOfUser);
    }

    //@Overide
    public void prepare() throws Exception {
        userObj = (UserDTO) session.get(SurveyActionSupport.USER);
        if(userObj==null){
            System.out.println("User Object is null.");
        }
    }

}