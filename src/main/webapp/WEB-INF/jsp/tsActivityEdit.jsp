<%@ include file="include/top.jsp" %>

<form name="form" action="tsActivityEdit.do" method="POST">

<table>
	<springx:id />
	<springx:row property="command.name" code="tsActivity.name"/>
	<springx:row property="command.description" code="tsActivity.description"/>
	<springx:submitRow/>
</table>
