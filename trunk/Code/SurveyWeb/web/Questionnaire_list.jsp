<%-- 
    Document   : questionnaire_list
    Created on : Jan 10, 2011, 11:20:07 PM
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
        <title><s:text name="survey.questionnaire_list_title"/></title> 
    </head>
    <body>

        <div id="questionnaire_list_title" align="left">
            <p>My Questionnaire List</p>
        </div>
        <div id="questionnaire_list" align="center">
        <form id="quest_list_form" action="" method="post">
            <fieldset style="text-align:left">
                    <legend class="legend_header">Recently Edit</legend>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                            <th scope="col" class="col_header" width="5%">S/No</th>
                            <th scope="col" class="col_header" width="15%">ID</th>
                            <th scope="col" class="col_header" width="20%">Title</th>
                            <th scope="col" class="col_header" width="30%">Description</th>
                            <th scope="col" class="col_header" width="15%">Activity Status</th>
                            <th scope="col" class="col_header" width="15%">Action</th>
                      </tr>
                      <tr class="table_oddRow">
                            <td align="center">1</td>
                            <td align="center">1111</td>
                            <td align="center">Course Survey</td>
                            <td align="center">Course Survey From ISS</td>
                            <td align="center">Pending</td>
                            <td align="center"><a href="" target="_blank">Edit</a>&nbsp;|&nbsp;<a href="" target="_blank">Delete</a></td>
                      </tr>
                      <tr class="table_evenRow">
                            <td align="center">2</td>
                            <td align="center">1112</td>
                            <td align="center">Facility Survey</td>
                            <td align="center">Facility Survey at ISS</td>
                            <td align="center">Published</td>
                            <td align="center"><a href="" target="_blank">Edit</a>&nbsp;|&nbsp;<a href="" target="_blank">Delete</a></td>
                      </tr>
                    </table>
            </fieldset>
            <br/>
            <br/>
            <fieldset style="text-align:left"><legend class="legend_header">Recently Submitted</legend>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                            <th scope="col" class="col_header" width="5%">S/No</th>
                            <th scope="col" class="col_header" width="15%">ID</th>
                            <th scope="col" class="col_header" width="20%">Title</th>
                            <th scope="col" class="col_header" width="30%">Description</th>
                            <th scope="col" class="col_header" width="15%">Total Respondents</th>
                            <th scope="col" class="col_header" width="15%">Action</th>
                      </tr>
                      <tr class="table_oddRow">
                            <td align="center">1</td>
                            <td align="center">1111</td>
                            <td align="center">Course Survey</td>
                            <td align="center">Course Survey From ISS</td>
                            <td align="center">123</td>
                            <td align="center"><a href="" target="_blank">Close</a></td>
                      </tr>
                      <tr class="table_evenRow">
                            <td align="center">2</td>
                            <td align="center">1112</td>
                            <td align="center">Facility Survey</td>
                            <td align="center">Facility Survey at ISS</td>
                            <td align="center">211</td>
                            <td align="center"><a href="" target="_blank">Close</a></td>
                      </tr>
                    </table>
            </fieldset>
        </form>
</div>
<div id="questionnaire_add" align="left">
<br/>
	<a href="" target="_blank" class="functional_hyperlink">Create New Questionnaire</a>
</div>
    </body>
</html>
