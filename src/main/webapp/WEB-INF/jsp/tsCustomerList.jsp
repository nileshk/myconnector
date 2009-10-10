<%@ include file="include/top.jsp" %>

Activities:<br/>
<display:table name="list" id="item" class="mars" export="false" sort="list" pagesize="20" requestURI="tsCustomerList.do">
  <display:column title="Edit" href="tsCustomerEdit.do" paramId="id" paramProperty="id">
		<spring:message code="option.edit"/>
  </display:column>
  <display:column property="name" title="Customer Name" sortable="true" />
  <display:column property="abbreviation" title="Abbreviation" sortable="true" />
</display:table>
<br>
<a href="tsCustomerEdit.do"><spring:message code="tsCustomer.createNew"/></a>