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


    <s:form action="leftMenu" method="post" namespace="/">
<table width="100%" border="0" cellpadding="0" cellspacing="5" class="leftMenu">
  <s:iterator value="" var="stat">
  <tr>
      <td><a href="" class=""><s:text name=""/></a></td>
  </tr>
  </s:iterator>
</table>
        </s:form>
