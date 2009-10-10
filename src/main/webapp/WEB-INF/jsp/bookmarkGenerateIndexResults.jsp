<%@ include file="include/taglib.jsp" %>
<app:top>
</app:top>
<h2>Generate Index Results</h2>
<p>
<c:if test="${errorMessage != null}">
	<b>Error: </b>${errorMessage}<br><br>
</c:if>
<c:if test="${errorMessage == null}">
Total pages generated: ${noPagesGenerated}<br><br>
Total failed pages: ${noErrors}<br><br>

Errored pages:
<table border="1">
<c:forEach var="error" items="${results.errors}">
<tr>
	<td>${error.url}</td>
	<td>${error.errorMessage}</td>
</tr>
</c:forEach>
</table>
<br>
Successfully indexed pages:
<table border="1">
<c:forEach var="url" items="${results.indexedPages}">
<tr>
	<td>${url}</td>
</tr>
</c:forEach>
</table>
</c:if>
</p>