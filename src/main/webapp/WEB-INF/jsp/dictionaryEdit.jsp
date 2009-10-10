<%@ include file="include/top.jsp" %>

<form name="form" action="dictionaryEdit.do" method="POST">

<table>
	<springx:row property="command.word" code="dictionary.word"/>
	<springx:row property="command.def" code="dictionary.def"/>
	<springx:submitRow/>
</table>
