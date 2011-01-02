
package com.team11.surveyquestionnaire.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Sai Lin Naung
 */

public class SurveyActionSupport extends ActionSupport implements
		ServletRequestAware, SessionAware, Preparable {

    protected HttpServletRequest request;
    protected Map<String, Object> session;

    public SurveyActionSupport() { }

    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void prepare() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}