<%-- 
    Document   : FindUser
    Created on : Jan 16, 2011, 9:41:16 PM
    Author     : a0005933L
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<html>
    <head>
        <sx:head/>
        <fmt:bundle basename="SurveyResource" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="FNDUSR"/></title>
    </head>
    <body>
        <s:form name="search_criteria" action="searchUsers_%{type}" namespace="/search" method="post">
            <table align="left" cellpadding="0" cellspacing="0">
                <tr>                    
                    <td><s:text name="finduser.fullname"/></td>
                    <td><s:textfield name="fullName" size="30" /></td>                    
                </tr>  
                <tr>
                    <td colspan="2"><s:label value="(OR)"/></td>
                </tr>
                <tr>
                    <td ><s:text name="Role"/>:</td>
                    <td>
                        <s:select name="roleName" list="roles" listKey="roleID" listValue="name"/>
                    </td>
                </tr>
            </table>
            <br/>
            <table align="center" cellpadding="5" cellspacing="0">
                <tr>
                    <td>
                        <sx:submit targets="result_div" type="button" value="%{'Search'}" />
                    </td>
                </tr>
            </table>
        </s:form>
        <s:if test="userList.size!=0">
        <div id="result_div">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                            <th scope="col" class="col_header" width="5%">S/No</th>
                            <th scope="col" class="col_header" width="15%">User ID</th>
                            <th scope="col" class="col_header" width="20%">User Name</th>
                            <th scope="col" class="col_header" width="30%">Full Name</th>
                            <th scope="col" class="col_header" width="15%">Email</th>
                            <th scope="col" class="col_header" width="15%">Role</th>
                            <th scope="col" class="col_header" width="15%">Action</th>
                     </tr>
                     
                
            </table>            
        </div>
        </s:if>
    </body>
</html>
