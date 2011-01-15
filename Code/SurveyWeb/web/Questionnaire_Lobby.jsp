<%-- 
    Document   : Questionnaire_Lobby
    Created on : Jan 12, 2011, 10:56:33 PM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="survey.questionnaire_list_title"/></title>
    </head>
    <body>              
        <div id="questionnaire_list" align="center">
        <s:form id="quest_list_form" action="QuestionnaireList_all" method="post">
            <fieldset style="text-align:left">
                    <legend class="legend_header">Recently Edit</legend>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                              <tr>
                                    <th scope="col" class="col_header" width="5%">S/No</th>
                                    <th scope="col" class="col_header" width="15%">ID</th>
                                    <th scope="col" class="col_header" width="20%">Title</th>
                                    <th scope="col" class="col_header" width="30%">Description</th>
                                    <th scope="col" class="col_header" width="15%">Activity Status</th>
                                    <th scope="col" class="col_header" width="15%">Action</th>
                              </tr>
                        <s:if test="recentEditList.size()==0">                            
                              <tr class="table_oddRow">
                                  <td align="center" class="" colspan="6">No recently editing survey.</td>
                              </tr>                            
                        <s:else>                            
                              <s:set id="idx" name="idx" value="0"/>
                              <s:iterator value="recentEditList" status="stat">
                                  <s:set id="idx" value="#idx+1"/>
                                  <tr class="<s:if test="#stat.odd == true">table_oddRow</s:if><s:else>table_evenRow</s:else>">
                                    <td align="center"><s:property value="#idx"/></td>
                                    <td align="center"><s:property value="surveyID"/></td>
                                    <td align="center"><s:property value="title"/></td>
                                    <td align="center"><s:property value="description"/></td>
                                    <td align="center"><s:property value="state"/></td>
                                    <td align="center"><a href="<s:url namespace="/researcher" action="updateQuestionniare_%{surveyID}" />">Edit</a>&nbsp;|&nbsp;<a href="<s:url namespace="/researcher" action="deleteQuestionnaire_%{surveyID}" />">Delete</a></td>
                                  </tr>
                              </s:iterator>                            
                               </s:else>
                    </s:if>  
                            </table>
                                         
            </fieldset>
            <br/>
            <br/>
            <fieldset style="text-align:left">
                <legend class="legend_header">Recently Submitted</legend>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                            <th scope="col" class="col_header" width="5%">S/No</th>
                            <th scope="col" class="col_header" width="15%">ID</th>
                            <th scope="col" class="col_header" width="20%">Title</th>
                            <th scope="col" class="col_header" width="30%">Description</th>
                            <th scope="col" class="col_header" width="15%">Total Respondents</th>
                            <th scope="col" class="col_header" width="15%">Action</th>
                      </tr>
                      <s:if test="recentSubmitList.size()==0"> 
                            <tr class="table_oddRow">
                                  <td align="center" class="" colspan="6">No recently submitted survey.</td>
                           </tr>
                           <s:else>   
                            <s:set id="idx" name="idx" value="0"/>
                              <s:iterator value="recentSubmitList" status="stat">
                                  <s:set id="idx" value="#idx+1"/>
                                  <tr class="<s:if test="#stat.odd == true">table_oddRow</s:if><s:else>table_evenRow</s:else>">
                                    <td align="center"><s:property value="#idx"/></td>
                                    <td align="center"><s:property value="surveyID"/></td>
                                    <td align="center"><s:property value="title"/></td>
                                    <td align="center"><s:property value="description"/></td>
                                    <td align="center"><s:property value="state"/></td>
                                    <td align="center"><a href="<s:url namespace="/researcher" action="updateQuestionniare_%{surveyID}" />">Edit</a>&nbsp;|&nbsp;<a href="<s:url namespace="/researcher" action="deleteQuestionnaire_%{surveyID}" />">Delete</a></td>
                                  </tr>
                              </s:iterator>
                             </s:else>  
                       </s:if>       
                    </table>
            </fieldset>
        </s:form>
</div>
<div id="questionnaire_add" align="left">
<br/>
	<a href="<s:url namespace="/researcher" action="newQuestionnaire_new" />" class="functional_hyperlink">Create New Questionnaire</a>
</div>
        
    </body>
</html>

