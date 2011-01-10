
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package survey.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import survey.dto.SurveyDTO;



/**
 *
 * @author Sai Lin Naung
 */

public class SurveyActionSupport extends ActionSupport implements
       ServletRequestAware, SessionAware {

    protected HttpServletRequest request;
    protected Map<String, Object> session;

    private SurveyDTO mySurveyDto;

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
    public SurveyDTO getMySurveyDto() {
        return mySurveyDto;
    }

    /**
     * @param mySurveyDto the mySurveyDto to set
     */
    public void setMySurveyDto(SurveyDTO mySurveyDto) {
        this.mySurveyDto = mySurveyDto;
    }

}