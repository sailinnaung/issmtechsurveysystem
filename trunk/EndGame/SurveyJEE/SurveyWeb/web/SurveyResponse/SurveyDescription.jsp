<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!--Author   Mahsa -->

<html>
    <head>
  <!--      <link href="<c:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
        <style>td { white-space:nowrap; }</style>   -->

        <style type="text/css">
            .style3
            {
                width: 710px;
            }
            .style6
            {
                width: 354px;
            }
            .style7
            {
                width: 102px;
            }
        </style>

    </head>

    
    <body>
  <s:form  namespace="/SurveyResponse" action="openResponsepage_0">
        
        <table class="style3" >
            <tr>
                <td  colspan="2">
                    Thanks for choosing this servey, you can check my server description bellow , 
            please click on start to answer questions.</td>
            </tr>
            <tr>
                <td class="style7">
                    Servey ID:</td>
                <td class="style6" >
                     <s:text name="survey.code"/></td>
            </tr>
            <tr>
                <td class="style7">
                    Servey Title :</td>
                <td class="style6" >
                    <s:text name="survey.title"/></td>
            </tr>
            <tr>
                <td class="style7">
                    Servey Description :</td>
                <td class="style6" >
                    <s:text name="survey.description"/></td>
            </tr>
            <tr>
                <td class="style7">
                    Server Qwner :</td>
                <td class="style6" >
                     <s:text name="survey.owner.fullName"/></td>
            </tr>
            <tr>
                <td class="style7">
                    Start Date :</td>
                <td class="style6">
                     <s:text name="survey.startDate.time"/></td>
            </tr>
            <tr>
                <td class="style7">
                    End Date:</td>
                <td class="style6" >
                    <s:text name="survey.endDate.time"/></td>
            </tr>
        </table>
        
        
             <s:submit key=" Start " />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <s:submit key="Cancel" namespace="/SurveyResponse" action="openHomePage_0"/>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </p>
             <s:submit key="Delete" namespace="/SurveyResponse" action="delete_0"/>
        </s:form>

</body>
</html>




