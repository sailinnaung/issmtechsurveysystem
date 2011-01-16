<%-- 
    Document   : LeftMenu
    Created on : Jan 11, 2011, 6:48:34 AM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>


   
<table width="100%" border="0" cellpadding="0" cellspacing="5" class="leftMenu">       
        
        <s:iterator var="function" value="#session.FUNCTIONS_USER" >
            <s:url id="actionUrl" namespace="/" action="leftMenu" >
                <s:param name="linkAction" value="#function.code"/>
            </s:url>
            <tr>
                <td><s:a href="%{actionUrl}" name="linkAction" ><s:property value="name"/></s:a></td>
            </tr>
       </s:iterator>

  <tr>
      <td><a href="<c:url value="/logout.action"/>" ><s:text name="leftMenu.LogOut"/></a></td>
  </tr>
</table>

        
