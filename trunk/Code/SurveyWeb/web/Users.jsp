<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
       <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/> 
        <title><s:text name="Title"/></title>
    </head>
    <body>
        <a href="<s:url namespace="/UserManagement" action="openNewUserForm_all"/>"><s:text name="Create New User"/></a>
        <br/><br/>
 
        <table class="borderAll">
            <tr>
                <th><s:text name="      Name      "/></th>
                <th><s:text name="    Password    "/></th>
                <th><s:text name="    Email    "/></th>
                <th><s:text name="    Role    "/></th>
                <th>&nbsp;</th>
            </tr>
      <s:iterator value="users" status="stat">
                <tr class="<s:if test="#stat.odd == true">odd</s:if><s:else>even</s:else>">
                    <td class="nowrap"><s:property value="username"/></td>
                    <td class="nowrap"><s:property value="password"/></td>
                    <td class="nowrap"><s:property value="email"/></td>
                    <td class="nowrap"><s:property value="role"/></td>
                    <td class="nowrap">
                        &nbsp;&nbsp;&nbsp;
                        <a href="<s:url namespace="/UserManagement" action="openUpdateForm_%{username}" />"><s:text name="   Edit"/></a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="<s:url namespace="/UserManagement" action="delete_%{username}" />"><s:text name="    Delete"/></a>
                    </td>
                </tr>
            </s:iterator>
        </table>
   
    </body>
</html>