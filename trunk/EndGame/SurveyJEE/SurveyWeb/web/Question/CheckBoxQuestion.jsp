<table cellspacing="0" cellpadding="0" style="width:100%;" border="0">
    <tr style="width:100%;height:40px;">
        <td style="width:100%;" colspan="2">
            <s:property value="text"/>
        </td>
    </tr>
    <tr><td>
    <s:if test="%{orientation==0}">
        <s:checkboxlist name="names[%{questionID}]" list="options" listKey="optionID" listValue="name" />
    </s:if>
    <s:else>
         <s:checkboxlist name="names[%{questionID}]" list="options" listKey="optionID" listValue="name"/>
    </s:else>
    </td>
    </tr>
</table>

