<%@ include file="include/top.jsp" %>

<form name="form" action="releaseEdit.do" method="POST">

<table>
	<spring:bind path="command.id">
		<input type="hidden"
			name="<c:out value="${status.expression}"/>" 
			value="<c:out value="${status.value}"/>"/>
	</spring:bind>
	<springx:row property="command.title" code="release.title"/>
	<springx:row property="command.versionNumber" code="release.versionNumber"/>
	<springx:row property="command.description" code="release.description"/>
	<springx:row property="command.instructions" code="release.instructions"/>
	<springx:row property="command.keywords" code="release.keywords"/>
	<tr>
		<td></td>
		<td>
			<input type="submit" name="submit.submit" value="Submit"/>
		</td>
	</tr>
</table>
