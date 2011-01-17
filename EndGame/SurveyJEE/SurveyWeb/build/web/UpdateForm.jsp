<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<html>
    <head>
     <!--   <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/> -->
        <style>td { white-space:nowrap; }</style>
        <title> Update  User </title>
    </head>
    <body>

        <h1>Update  User</h1>
        <s:form namespace="user" action="update_%{user.username}">
			<s:actionerror/>
            <table>
                <tr>
                    <td class="tdLabel"><s:text name="UserName"/>:</td>
                    <td><s:textfield name="user.username" size="30" readonly="true"/>
                        <s:fielderror><s:param>user.username</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td class="tdLabel"><s:text name="Password"/>:</td>
                    <td><s:password name="user.password" size="30"/>
                    <s:fielderror><s:param>user.password</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td class="tdLabel"><s:text name="Email"/>:</td>
                    <td><s:textfield name="user.email" size="40"/>
                    <s:fielderror><s:param>user.email</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td class="tdLabel"><s:text name="Role"/>:</td>
                    <td>
                        <s:select name="user.role" list="{'admin','user'}"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <br/>
                        <s:submit label="Update"/>
                  
                         <s:submit key="Cancel" namespace="/UserManagement" action="openUserList_all"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>