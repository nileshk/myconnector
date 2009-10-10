<%@ include file="include/top.jsp" %>

<table>
	<springx:rowView property="release.title" code="release.title"/>
	<springx:rowView property="release.versionNumber" code="release.versionNumber"/>
	<springx:rowView property="release.description" code="release.description"/>
	<springx:rowView property="release.instructions" code="release.instructions"/>
	<springx:rowView property="release.keywords" code="release.keywords"/>
</table>

List of files:<br/>
<display:table name="fileList" id="file" class="mars" export="true" sort="list" pagesize="20" requestURI="fileList.do">
  <display:column title="Download" href="fileDownload.do" paramId="id" paramProperty="id">
		Download
  </display:column>
  <display:column title="Delete">
  		<form action="releaseFileDelete.do" method="POST">
			<input type="hidden" name="id" value="${file.id}"/>
			<input type="hidden" name="returnId" value="${release.id}"/>
  			<input type="submit" name="submit.delete" value="<spring:message code="option.delete"/>"/>
  		</form> 
  </display:column>
  <display:column property="fileName" title="Name" sortable="true" />
  <display:column property="fileSize" title="Size" sortable="true" />
  <display:column property="fileType" title="Type" sortable="true" />
  <display:column property="fileDescription" title="Description" sortable="true" />
</display:table>

List of users:<br/>
<display:table name="userList" id="user" class="mars" sort="list" pagesize="20" requestURI="userListSelection.do">
  <display:column title="Delete">
  		<form action="releaseUserDelete.do" method="POST">
			<input type="hidden" name="userId" value="${user.id}"/>
			<input type="hidden" name="releaseId" value="${release.id}"/>
  			<input type="submit" name="submit.delete" value="<spring:message code="option.delete"/>"/>
  		</form>
  </display:column>
  <display:column property="userLogin" title="Login" sortable="true" />
  <display:column property="securityLevel" title="Security Level" sortable="true" />
</display:table>

<a href="releaseFileUpload.do?releaseId=${release.id}">Upload a file for this release</a><br>
<a href="releaseUserSelection.do?id=${release.id}">Add users access to this release</a><br>