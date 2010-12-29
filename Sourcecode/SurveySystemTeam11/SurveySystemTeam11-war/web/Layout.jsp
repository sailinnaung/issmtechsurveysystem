<%-- 
    Document   : Layout
    Created on : Dec 26, 2010, 11:34:47 PM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
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
                    <div class="titleDiv"><fmt:message key="${bodyTitle}"/></div>
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
