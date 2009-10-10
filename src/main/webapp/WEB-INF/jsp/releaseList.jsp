<%@ include file="include/top.jsp" %>

  List of releases:<br/>
	<display:table name="list" id="item" class="mars" export="true" sort="list" pagesize="20" requestURI="releaseList.do">
	  <display:column title="View" href="releaseView.do" paramId="id" paramProperty="id">
			<spring:message code="option.view"/>
	  </display:column>
	  <display:column title="Edit" href="releaseEdit.do" paramId="id" paramProperty="id">
			<spring:message code="option.edit"/>
	  </display:column>
	  <display:column title="Delete">
	  		<form action="releaseDelete.do" method="POST">
				<input type="hidden" name="id" value="${item.id}"/>
	  			<input type="submit" name="submit.delete" value="<spring:message code="option.delete"/>"/>
	  		</form>
	  </display:column>
	  <display:column title="Upload" href="releaseFileUpload.do" paramId="releaseId" paramProperty="id">
			<spring:message code="option.upload"/>
	  </display:column>
	  <display:column property="title" title="Title" sortable="true" />
	  <display:column property="versionNumber" title="Version" sortable="true" />
	  <display:column property="createdDate" title="Date Created" sortable="true" />
	  <display:column property="ready" title="Ready" sortable="true" />
	  <display:column property="createdBy.userLogin" title="Created By" sortable="true" />
	</display:table>
<br>
<a href="releaseEdit.do">Create new release</a>