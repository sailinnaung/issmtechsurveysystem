<%-- 
    Document   : Questionnaire_new
    Created on : Jan 11, 2011, 6:10:37 AM
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
        <title><s:text name="survey.questionnaire_new_title"/></title>
    </head>
    <body>
        <form id="questionnaire_new_form" action="" method="post">
	<div id="questionnaire_new_title" align="center"><p>New Questionnaire</p></div>
	<div id="questionnaire_new_details" align="center">
		<table cellpadding="0" cellspacing="0" width="100%" border="0">
		  <tr>
			<th scope="row" class="quest_label_new" width="30%">Questionnaire ID :</th>
			<td><input name="questIdText" type="text" size="25%" /></td>
		  </tr>
		  <tr>
			<th scope="row" class="quest_label_new" width="30%">Questionnaire Title :</th>
			<td><input name="questIdText" type="text" size="50%" /></td>
		  </tr>
		  <tr>
			<th scope="row" class="quest_label_new" width="30%">Description :</th>
			<td><textarea name="questDescTextArea" cols="" rows="5"></textarea></td>
		  </tr>
		  <tr>
			<th scope="row" class="quest_label_new" width="30%">Publishing Date :</th>
			<td><input name="questPublishDateText" type="text" size="25" />
			  <img src="" alt="calander" name="calander" width="32" height="32" id="calander" style="background-color: #009999" /></td>
		  </tr>
		  <tr>
			<th scope="row" class="quest_label_new" width="30%">Expire Date :</th>
			<td><input name="questExpireDateText" type="text" size="25" />
			  <img src="" alt="calander" name="calander" width="32" height="32" id="calander" style="background-color: #009999" /></td>
		  </tr>
	</table>
	</div>
	<div id="questionnaire_new_button" align="center">
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
