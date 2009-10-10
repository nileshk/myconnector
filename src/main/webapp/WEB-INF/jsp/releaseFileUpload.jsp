<%@ include file="include/top.jsp" %>

<form name="form" action="releaseFileUpload.do" method="POST" enctype="multipart/form-data">

<input type="hidden" name="releaseId" value="${param.releaseId}"/>

<table>
	<tr>
		<td>File:</td>
		<spring:bind path="command.file">
		<td><input type="file" name="${status.expression}" size="80"/></td>
		</spring:bind>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" name="submit.upload" value="Upload"/>
		</td>
	</tr>
</table>
