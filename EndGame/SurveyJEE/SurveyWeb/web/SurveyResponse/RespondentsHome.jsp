<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!--Author   Mahsa -->
<html>
    <head>
     <!--  <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/> -->
        <title>Respondent Home </title>
    </head>
    <body>
       
        <h1><s:text name="Welcome Respondent"/></h1>
       
        <br/><br/>
 
        <table >
            <tr>
                <th><s:text name="      Survey ID     "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="     Title  "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="    Owner   "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="    Close Date   "/></th>
                <th>&nbsp;</th>
            </tr>
      <s:iterator value="draftSurvays" status="stat">
                <tr class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                    <td class="nowrap"><s:property value="surveyID"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="title"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="owner.fullName"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endDate.time"/></td>
                    <td class="nowrap">
                        &nbsp;&nbsp;&nbsp;
                        <a href="<s:url namespace="/SurveyResponse" action="openSurveyDescription_%{surveyID}" />"><s:text name="   Edit"/></a>
                        &nbsp;&nbsp;&nbsp;

                    </td>
                </tr>
            </s:iterator>
        </table>

     <!-- ################################################################## -->
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

 <table >
            <tr>
                <th><s:text name="      Survey ID     "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="     Title  "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="    Owner   "/></th>
                <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="    Close Date   "/></th>
                <th>&nbsp;</th>
            </tr>
      <s:iterator value="openSurvays" status="stat">
                <tr class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                    <td class="nowrap"><s:property value="surveyID"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="title"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="owner.fullName"/></td>
                    <td class="nowrap">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="endDate.time"/></td>
                   <td class="nowrap">
                        &nbsp;&nbsp;&nbsp;
                        <a href="<s:url namespace="/SurveyResponse" action="openSurveyDescription_%{surveyID}" />"><s:text name="   Reply"/></a>
                        &nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
            </s:iterator>
        </table>
   
    </body>
</html>