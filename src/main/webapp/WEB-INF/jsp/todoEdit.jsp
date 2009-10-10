<%@ include file="include/top.jsp" %>

<form name="form" action="todoEdit.do" method="POST">

<table>
	<springx:id />
	<springx:row property="command.description" code="todo.description"/>
	<springx:row property="command.level" code="todo.level"/>
	<springx:submitRow/>
</table>
