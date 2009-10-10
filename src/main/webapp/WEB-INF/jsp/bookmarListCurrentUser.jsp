<%@ include file="include/taglib.jsp" %>
<app:top>
	<link rel="alternate" type="application/rss+xml" title="RSS" href="bookmarkRSS.do?user=${username}" />
</app:top>
<a href="bookmarkRSS.do?user=${username}">RSS Feed</a><br>
<br>

  List of bookmarks:<br/>
	<display:table name="bookmarkList" id="bookmark" class="mars" export="true" sort="list" pagesize="20" requestURI="list.do">
	  <display:column title="Edit" href="edit.do" paramId="id" paramProperty="id">
			Edit
	  </display:column>
	  <display:column title="Delete" href="delete.do" paramId="id" paramProperty="id">
			Delete2 ${bookmark.id}
	  </display:column>
	  <display:column property="userData.userLogin" title="User" sortable="true" headerClass="sortable" href="user.do" paramId="id" paramProperty="userData.id"/>
	  <display:column title="URL" sortable="true" headerClass="sortable">
			<a href="<c:out value="${bookmark.url}"/>">
				${fn:substring(bookmark.url, 0, 50)}
			</a>
	  </display:column>
	  <display:column property="title" title="Title" sortable="true" headerClass="sortable"/>
		<display:column property="folder" title="Folder" sortable="true" headerClass="sortable"/>
		<display:column property="description" title="Description" sortable="true" headerClass="sortable"/>
		<display:column title="Add Date" sortable="true" headerClass="sortable">
			<fmt:formatDate value="${bookmark.addDate}" pattern="yyyy-MM-dd"/>
		</display:column>
		<display:column title="Last Visit" sortable="true" headerClass="sortable">
			<fmt:formatDate value="${bookmark.lastVisit}" pattern="yyyy-MM-dd"/>
		</display:column>
		<display:column property="keywords" title="Keywords" sortable="true" headerClass="sortable"/>
	</display:table>
  <c:if test="${not empty deleteFailed}">
  <FONT color="red">
  	Delete failed: Bookmark not found.<br/>
  </FONT>
  </c:if>

<!--  
	<c:forEach var="bookmark" items="${bookmarkList}">
		<c:out value="${bookmark.id}"/> - <a href="<c:out value="${bookmark.url}"/>">
		<c:out value="${bookmark.url}"/></a><br/>
	</c:forEach>
-->
  </body>
</html>
