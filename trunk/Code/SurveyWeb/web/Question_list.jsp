<%-- 
    Document   : Question_list
    Created on : Jan 11, 2011, 6:13:37 AM
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
        <title><s:text name="survey.question_list_title"/></title>
    </head>
    <body>
        <div id="question_list_header">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <th width="35%" class="quest_label_new" scope="row">Questionnaire ID :</th>
    <td width="65%"><label id="questionnaire_label_id">1111</label></td>
  </tr>
  <tr>
    <th width="35%"  scope="row" class="quest_label_new">Questionnaire Title :</th>
    <td width="65%"><label id="questionnaire_label_title">Survey Questionnaire Title</label></td>
  </tr>
</table>
</div>
<br/>
<fieldset><legend class="legend_header">Question List</legend>
<form action="" method="post" name="question_list_form">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
		<th scope="col" class="col_header">Order</th>
		<th scope="col" class="col_header">Code</th>
		<th scope="col" class="col_header">Text</th>
		<th scope="col" class="col_header">Description</th>
		<th scope="col" class="col_header">State</th>
		<th scope="col" class="col_header">Question Type</th>
		<th scope="col" class="col_header">Is Madatory?</th>
		<th scope="col" class="col_header">Action</th>
	  </tr>
	  <tr class="table_oddRow">
		<td>1</td>
		<td>CAT1</td>
		<td>How are you?</td>
		<td>Nil</td>
		<td>Open</td>
		<td>MCQ</td>
		<td>Yes</td>
		<td><a href="" target="_blank">Edit</a>&nbsp;|&nbsp;<a href="" target="_blank">Delete</a></td>
	  </tr>
	  <tr class="table_evenRow">
		<td>2</td>
		<td>CAT1</td>
		<td>Felling Well?</td>
		<td>Nil</td>
		<td>Open</td>
		<td>MCQ</td>
		<td>No</td>
		<td><a href="" target="_blank">Edit</a>&nbsp;|&nbsp;<a href="" target="_blank">Delete</a></td>
	  </tr>
</table>
<br/>
<div id="question_add" align="left">
<br/>
	<a href="" target="_blank" class="functional_hyperlink">Add New Question</a>
</div>
</form>
</fieldset>

    </body>
</html>
