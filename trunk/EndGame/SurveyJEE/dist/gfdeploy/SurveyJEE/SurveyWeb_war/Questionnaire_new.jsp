<%-- 
    Document   : Questionnaire_new
    Created on : Jan 11, 2011, 6:10:37 AM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <sx:head/>
        <title><s:text name="survey.questionnaire_new_title"/></title>
    </head>
    <body>
        <fmt:setBundle basename="SurveyResource"/>
        <s:form namespace="/questionnaire" id="questionnaire_new_form" action="createQuestionniare_%{currentSurvey.surveyID}" method="post">
	<div id="questionnaire_new_details" align="center">
               <s:if test="currentSurvey.surveyID==null">
                <table cellpadding="0" cellspacing="0" width="100%" border="0">
                      <tr style="width:100%">
                            <th scope="row" class="quest_label_new" width="30%">Survey ID :</th>
                            <td>                            
                                <s:textfield name="currentSurvey.code" size="25%" cssClass="mandatory_textBox"/>                        
                            </td>
                      </tr>
                      <tr>
                            <th scope="row" class="quest_label_new" width="30%">Survey Title :</th>
                            <td><s:textfield name="currentSurvey.title" size="50%" cssClass="mandatory_textBox"/></td>
                      </tr>
                      <tr>
                            <th scope="row" class="quest_label_new" width="30%">Description :</th>
                            <td><s:textarea name="currentSurvey.description" rows="5" cols="10"/></td>
                      </tr>
                      <tr>			
                            <td colspan="2"><sx:datetimepicker name="currentSurvey.startDate" cssClass="quest_label_new" label="Publish Date:(dd-MM-yyyy)" displayFormat="dd-MM-yyyy"/></td>
                      </tr>
                      <tr>			
                            <td colspan="2"><sx:datetimepicker name="currentSurvey.endDate" cssClass="quest_label_new" label="Expire Date:(dd-MM-yyyy)" displayFormat="dd-MM-yyyy"/></td>
                      </tr>
                </table>
            </s:if>
            <s:else>
                <table cellpadding="0" cellspacing="0" width="100%" border="0">
                      <tr style="width:100%">
                            <th scope="row" class="quest_label_new" width="30%">Survey ID :</th>
                            <td>                            
                                <s:textfield name="currentSurvey.code" value="%{currentSurvey.code}" size="25%" cssClass="mandatory_textBox"/>
                            </td>
                      </tr>
                      <tr>
                            <th scope="row" class="quest_label_new" width="30%">Survey Title :</th>
                            <td><s:textfield name="currentSurvey.title" value="%{currentSurvey.title}" size="50%" cssClass="mandatory_textBox"/></td>
                      </tr>
                      <tr>
                            <th scope="row" class="quest_label_new" width="30%">Description :</th>
                            <td><s:textarea name="currentSurvey.description" value="%{currentSurvey.description}" rows="5" cols="10"/></td>
                      </tr>
                      <tr>			
                          <td colspan="2"><sx:datetimepicker name="currentSurvey.startDate" value="%{currentSurvey.startDate}" cssClass="quest_label_new" label="Publish Date:(dd-MM-yyyy)" displayFormat="dd-MM-yyyy"/></td>
                      </tr>
                      <tr>			
                          <td colspan="2"><sx:datetimepicker name="currentSurvey.endDate" value="%{currentSurvey.endDate}" cssClass="quest_label_new" label="Expire Date:(dd-MM-yyyy)" displayFormat="dd-MM-yyyy"/></td>
                      </tr>
                </table>
            </s:else>
	</div>
	<div id="questionnaire_new_button" align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>                      
                      <td  align="center"><s:submit name="submitBtn" value="Create/Update" label="Create"/></td>
                      <td  align="center"><s:reset label="Reset"/></td>
		  </tr>                  
		</table>
	</div>        
</s:form>
    </body>
</html>
