/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dto;

import java.util.Calendar;

/**
 *
 * @author vivek
 */
public class SurveySearchCriteriaDTO implements java.io.Serializable {

    private String keywords;
    private boolean includeClosed;
    private boolean includeInvalid;
    private String title;
    private Calendar createDateFrom;
    private Calendar createDateTo;
    private boolean activeFlg;
    
    public SurveySearchCriteriaDTO() {
        createDateFrom = null;
        createDateTo = null;
        keywords = "";
        title = "";
    }

    public boolean isActive() {
        return activeFlg;
    }

    public void setActive(boolean activeFlg) {
        this.activeFlg = activeFlg;
    }

    public Calendar getCreateDateFrom() {
        return createDateFrom;
    }

    public void setCreateDateFrom(Calendar createDateFrom) {
        this.createDateFrom = createDateFrom;
    }

    public Calendar getCreateDateTo() {
        return createDateTo;
    }

    public void setCreateDateTo(Calendar createDateTo) {
        this.createDateTo = createDateTo;
    }

    public boolean isIncludeClosed() {
        return includeClosed;
    }

    public void setIncludeClosed(boolean includeClosed) {
        this.includeClosed = includeClosed;
    }

    public boolean isIncludeInvalid() {
        return includeInvalid;
    }

    public void setIncludeInvalid(boolean includeInvalid) {
        this.includeInvalid = includeInvalid;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
