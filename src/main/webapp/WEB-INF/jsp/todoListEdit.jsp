<%@ include file="include/top.jsp" %>

<form name="form" action="todoListEdit.do" method="POST">

<table>
	<springx:id />
	<springx:row property="command.title" code="todolist.title"/>
	<springx:submitRow/>
</table>
