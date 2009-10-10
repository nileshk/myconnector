<%@ include file="include/top.jsp" %>

<div id="title">
Timesheet:
</div>
<br/>
<br/>

<table class="inputform">
	<form action="<c:url value="timesheetFilter.do"/>" method="post">
	<tr>
		<td>
			Date:
		</td>
		<td>
			<input type="text" name="dateFilter" value="<fmt:formatDate value="${SdateFilter}" pattern="MM/dd/yyyy"/>" size="20"/>
		</td>
		<td>
			Week:
		</td>
		<td>
			<input type="text" name="weekFilter" value="<fmt:formatDate value="${SweekFilter}" pattern="MM/dd/yyyy"/>" size="20"/>
		</td>
		<td>
			<input class="input-button" type="submit" name="submit.apply" value="<spring:message code='submit.apply'/>"/>
		</td>
	</tr>
	</form>
</table>

<display:table name="entryList" id="item" class="mars" export="false" sort="list" pagesize="20" requestURI="timesheet.do">
<%--  <display:column title="Edit" href="tsCustomerEdit.do" paramId="id" paramProperty="id">
		<spring:message code="option.edit"/>
  </display:column>--%>
  <display:column property="hours" titleKey="tsEntry.hours" sortable="true" />
  <display:column titleKey="tsEntry.dateOccur" sortable="true">
  	<fmt:formatDate value="${item.dateOccur}" pattern="${datePattern}"/>
  </display:column> 
  <display:column titleKey="tsEntry.dateTimeStart" sortable="true">
  	<fmt:formatDate value="${item.dateTimeStart}" pattern="${dateTimePattern}"/>
  </display:column> 
  <display:column property="description" titleKey="tsEntry.description" sortable="true" />  
  <display:column property="activity.name" titleKey="tsActivity" sortable="true" />
  <display:column property="customer.name" titleKey="tsCustomer" sortable="true" />
  <display:column titleKey="column.action" paramProperty="id" paramId="id" href="timesheetComplete.do">
  	<c:if test="${empty item.hours && not empty item.dateTimeStart}">
  		Complete
  	</c:if>
  </display:column>
</display:table>
<br>
<table class="inputform" border="0">
<form action="<c:url value="timesheet.do"/>" method="post">
	<springx:row property="command.hours" code="tsEntry.hours"/>
<%--	<springx:row property="command.dateTimeStart" code="tsEntry.dateTimeStart"/>--%>
	<springx:row property="command.description" code="tsEntry.description" size="100"/>
   	<springx:rowSelection property="command.activity.id" list="${activityList}" code="tsActivity"/>
   	<springx:rowSelection property="command.customer.id" list="${customerList}" code="tsCustomer"/>	
	<tr>
		<td/>
		<td><input class="input-button" type="submit" name="submit.save" value="<spring:message code='submit.save'/>"/></td>
	</tr>
</form>   	
</table>
