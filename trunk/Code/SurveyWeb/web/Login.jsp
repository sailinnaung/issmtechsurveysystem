<%@ page contentType="text/html"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="survey.logintitle"/></title>
    </head>
    <body>
        <s:actionerror/>
        <s:form namespace="/" action="authenticate.action" focusElement="username">
            <table width="450" >
                <tr>
                    <td> &nbsp; </td>
                    <td> &nbsp; <s:fielderror><s:param>login</s:param></s:fielderror></td>
                </tr>
                <tr> 
                    <td><s:text name="fieldLabel.username"/></td>
                    <td ><s:textfield name="username" size="40" maxlength="40"/>
                    <s:fielderror><s:param>user</s:param></s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td> &nbsp; </td>
                    <td> &nbsp; </td>
                </tr>
                <tr>
                    <td><s:text name="fieldLabel.password"/></td>
                    <td ><s:password name="password" size="40" maxlength="40"/>
                    <s:fielderror><s:param>password</s:param></s:fielderror>
                    </td>
                </tr>
                <tr>
                    <td> &nbsp; </td>
                    <td> &nbsp; </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <s:submit label="button.label.login" align="middle" />
                        &nbsp;&nbsp;&nbsp;
                        <s:reset label="button.label.reset"  align="middle" />
                    </td>
                </tr>
                <tr>
                    <td> &nbsp; </td>
                    <td> &nbsp; </td>
                </tr>
            </table>
            
        </s:form>
    </body>
</html>