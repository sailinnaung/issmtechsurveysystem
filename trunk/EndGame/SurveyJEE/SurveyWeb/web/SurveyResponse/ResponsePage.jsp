<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!--Author   Mahsa -->
<html>
    <head>

    </head>
    <body>
        <s:form  namespace="/SurveyResponse" action="saveResponsepage_0">
            <table cellspacing="0" cellpadding="0" border="0" style="width:100%;">
                <tr style="width:100%;">
                    <td style="width:100%;">
                        <h1>Response</h1>
                    </td>
                </tr>
              <s:iterator value="questions" status="stat">

                 <tr style="width:100%;">
                    <td style="width:100%;">
                 <s:if test="%{questionType==0}">
                    <%@ include file="/Question/TextQuestion.jsp" %>
                 </s:if>
                 <s:elseif test="%{questionType==1}">
                    <%@ include file="/Question/TextQuestion.jsp" %>
                 </s:elseif>
                 <s:elseif test="%{questionType==2}">
                     <%@ include file="/Question/CheckBoxQuestion.jsp" %>
                 </s:elseif>
                   <s:elseif test="%{questionType==3}">
                     <%@ include file="/Question/RadioQuestion.jsp" %>
                 </s:elseif>
                  <s:elseif test="%{questionType==4}">
                     <%@ include file="/Question/RadioQuestion.jsp" %>
                 </s:elseif>
                 <s:else>
                     <%@ include file="/Question/TextQuestion.jsp" %>
                 </s:else>
                    </td>
                 </tr>
              </s:iterator>
                 <tr style="width:100%;">
                     <td colspan="2">
                         <s:submit key=" Next Page " align="left" />
                     </td>
                 </tr>
            </table>
        </s:form>
    </body>
</html>