<%@ include file="include/top.jsp" %>

Dictionary:<br/>
<display:table name="list" id="item" class="mars" export="true" sort="list" pagesize="20" requestURI="dictionaryList.do">
<%--  <display:column title="View" href="dictionaryView.do" paramId="id" paramProperty="id">
		<spring:message code="option.view"/>
  </display:column>
  <display:column title="Edit" href="dictionaryEdit.do" paramId="id" paramProperty="id">
		<spring:message code="option.edit"/>
  </display:column>
  <display:column title="Delete" href="dictionaryDelete.do" paramId="id" paramProperty="id">
		<spring:message code="option.delete"/>
  </display:column>--%>
  <display:column property="word" title="Word" sortable="true" />
  <display:column property="def" title="Definition" sortable="true" />
</display:table>
<br>
<a href="dictionaryEdit.do">Create new dictionary entry</a>