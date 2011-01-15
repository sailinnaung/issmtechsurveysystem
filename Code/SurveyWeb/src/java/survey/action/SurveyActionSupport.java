
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

    protected HttpServletRequest request;
    protected Map<String, Object> session;

    private SurveyDTO currentSurvey;
    private UserDTO userObj;
    private Map<String,List<FunctionDTO>> functionsOfUser=new HashMap<String, List<FunctionDTO>>();

    public SurveyActionSupport() {
    }

    //@Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpSession getSession(boolean b) {
        return request.getSession(b);
    }

    //@Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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


    public Map<String,List<FunctionDTO>> getFunctions(){
        return this.functionsOfUser;
    }

    public boolean addFunctions(String roleName,List<FunctionDTO> funcs){
        boolean successFlag = false;
        if(roleName!=null && roleName.length()>0){
            this.functionsOfUser.put(roleName, funcs);
            successFlag = true;
        }
        return successFlag;
    }

    public void setFunctions(){       
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