<%-- 
    Document   : TextQuestionCreationForm
    Created on : Jan 11, 2011, 7:07:37 AM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<table width="100%" border="0" cellpadding="0" cellspacing="2">
  <tr>
    <th scope="row" class="quest_label_new">Is Multiple Line?</th>
    <td>
		<table width="30%">
 		 <tr>
    		<td><label>
     		 	<input type="radio" name="questMultipleLine" value="radio" />
      			Yes</label>
			</td>
    		<td><label>
      			<input type="radio" name="questMultipleLine" value="radio" />
     			No</label>
			</td>
  		</tr>
	   </table>
	</td>
  </tr>
  <tr>
    <th scope="row" class="quest_label_new">Maximum Char Length :</th>
    <td><input name="maxCharLength" type="text" size="25" maxlength="5" /></td>
  </tr>
  <tr>
    <th scope="row" class="quest_label_new">Input Validation (If any) :</th>
    <td><input name="maxCharLength" type="text" size="50" maxlength="100" /></td>
  </tr>
  <tr>
    <th scope="row" class="quest_label_new">Default Text (If any) :</th>
    <td><input name="maxCharLength" type="text" size="50" maxlength="150" /></td>
  </tr>
</table>
