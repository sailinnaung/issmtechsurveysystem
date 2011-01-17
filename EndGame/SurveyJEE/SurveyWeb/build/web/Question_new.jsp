<%-- 
    Document   : Question_new
    Created on : Jan 11, 2011, 6:20:18 AM
    Author     : Sai Lin Naung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
    <head>
        <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <title><s:text name="survey.question_new_title"/></title>
    </head>
    <body>
        <form action="" method="post" name="question_creation_form">
<h3 align="center"><p>Add New Question</p></h3>
<div id="question_creation_detail">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <th scope="row" width="35%" class="quest_label_new">Question Order No. :</th>
    <td><input name="questOrderNo" type="text" size="25" maxlength="3" /></td>
  </tr>
  <tr>
    <th scope="row" width="35%"  class="quest_label_new">Question Code :</th>
    <td><input name="questCode" type="text" size="25"/></td>
  </tr>
  <tr>
    <th scope="row" width="35%"  class="quest_label_new">Question Text :</th>
    <td><input name="questText" type="text" size="100" maxlength="3" /></td>
  </tr>
  <tr>
    <th scope="row" width="35%"  class="quest_label_new">Description :</th>
    <td><textarea name="questDesc" cols="" rows="3"></textarea></td>
  </tr>
  <tr>
    <th scope="row" width="35%"  class="quest_label_new">Is Mandatory? :</th>
    <td>
		<table width="30%">
 		 <tr>
    		<td><label>
     		 	<input type="radio" name="questMandatoryGrp" value="radio" />
      			Yes</label>
			</td>
    		<td><label>
      			<input type="radio" name="questMandatoryGrp" value="radio" />
     			No</label>
			</td>
  		</tr>
	   </table>
	</td>
  </tr>
  <tr>
    <th scope="row" width="35%"  class="quest_label_new">Question Types :</th>
    <td>
		<select name="questTypeSelection">
			<option value="TEXT" selected="selected">Text</option>
			<option value="NUMBER">Number</option>
			<option value="MCQ">MCQ</option>
			<option value="RATING">Rating</option>
			<option value="COMPOSITE">Composite</option>
		</select>
	</td>
  </tr>
</table>


</div>
<div id="question_type_detail">
<!-- Include JSP or Ajax will be added for this section -->
</div>
<div id="question_creation_buttons">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
		  <tr>
			<td  align="center"><input name="questCreate" type="submit" value="Save" /></td>
			<td  align="center"><input name="questPublish" type="submit" value="Submit" /></td>
			<td  align="center"><input name="reset" type="reset" value="Reset" /></td>
		  </tr>
</table>
</div>
</form>
    </body>
</html>
