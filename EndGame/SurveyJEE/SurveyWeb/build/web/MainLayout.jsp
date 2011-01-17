<%-- 
    Document   : MainLayout
    Created on : Jan 9, 2011, 5:59:02 PM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
    <head/>
    <body>
        <table width="100%">
            <tr>
                <td width="100%">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="150" valign="top">
                    <tiles:insertAttribute name="menu"/>
                </td>
                <td align="left" width="80%">
                    <tiles:useAttribute id="bodyTitle" name="bodyTitle"/>
                    <div class="body_title"><fmt:message key="${bodyTitle}"/></div>
                    <tiles:insertAttribute name="body"/>
                </td>
            </tr>
        </table>
        <table width="100%">
            <tr>
                <td width="100%">
                    <tiles:insertAttribute name="footer"/>
                </td>
            </tr>
        </table>

    </body>
</html>
