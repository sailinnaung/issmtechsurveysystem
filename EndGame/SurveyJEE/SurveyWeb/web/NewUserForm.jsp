<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
   <!--     <style>td { white-space:nowrap; }</style>   -->
        <title> Add New User </title>
    </head>
    <body>
        <s:form namespace="user" action="addUser_%{user.username}">
			<s:actionerror/>
            <table>
                <tr>
                    <td ><s:text name="User Name"/>:</td>
                    <td><s:textfield name="user.username" size="30" />
                        <s:fielderror><s:param>user.username</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td ><s:text name="Full Name"/>:</td>
                    <td><s:textfield name="user.fullName" size="30" />
                        <s:fielderror><s:param>user.fullname</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td><s:text name="Password"/>:</td>
                    <td><s:password name="user.password" size="30"/>
                    <s:fielderror><s:param>user.password</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td ><s:text name="Email"/>:</td>
                    <td><s:textfield name="user.email" size="40"/>
                    <s:fielderror><s:param>user.email</s:param></s:fielderror></td>
                </tr>
                <tr>
                    <td ><s:text name="Role"/>:</td>
                    <td>
                        <s:select name="roleName" list="roles" listKey="roleID" listValue="name"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                    
                        <s:submit label="Submit"/>
                    </td>
                    <td>
                        <s:submit key="Cancel" namespace="/UserManagement" action="openUserList_all"/>
                    </td>
                </tr>
            </table>
        </s:form>
    </body>
</html>