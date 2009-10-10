<%@ include file="include/top.jsp" %>

Activities:<br/>
<display:table name="list" id="item" class="mars" export="false" sort="list" pagesize="20" requestURI="tsActivityList.do">
  <display:column title="Edit" href="tsActivityEdit.do" paramId="id" paramProperty="id">
		<spring:message code="option.edit"/>
  </display:column>
  <display:column property="name" title="Activity Name" sortable="true" />
  <display:column property="description" title="Description" sortable="true" />
</display:table>
<br>
<a href="tsActivityEdit.do"><spring:message code="tsActivity.createNew"/></a>