<%@ include file="include/taglib.jsp" %>
<app:top>
  <app:deleteConfirmation code="delete.todoitem.confirm"/>
</app:top>

Activities:<br/>
<display:table name="list" id="item" class="mars" export="false" sort="list" pagesize="20" requestURI="todoLists.do">
  <display:column title="Edit" href="todoItemEdit.do" paramId="id" paramProperty="id">
		<spring:message code="option.edit"/>
  </display:column>
  <display:column title="Delete">
  		<form action="todoItemDelete.do" method="POST" onsubmit="return deleteConfirmation()">
			<input type="hidden" name="id" value="${item.id}"/>
  			<input class='ibutton' type="submit" name="submit.delete" value="Delete"/>
  		</form>
  </display:column>  
  <display:column property="title" title="Title" sortable="true" />
</display:table>
<br>
Todo: form to add new item