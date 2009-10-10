<%@ include file="include/taglib.jsp" %>
<app:top>
	<link rel="alternate" type="application/rss+xml" title="RSS" href="bookmarkRSS.do?user=${username}" />
	<script type='text/javascript' src='/myconnector/dwr/interface/BookmarkAJAX.js'></script>
	<script type='text/javascript' src='/myconnector/dwr/engine.js'></script>
	<script type='text/javascript' src='/myconnector/dwr/util.js'></script>	
  <script>
	function verifyDeleteBookmark() {
	    var x=window.confirm("<spring:message code="delete.bookmark.confirm"/>")
		if (x) {
			return true;
		} else {
			return false;
		}
	}
  </script>  
</app:top>

<a href="bookmarkRSS.do?user=${username}"><img src="img/xml.png" alt="XML Feed" title="XML Feed"/></a><br>
<br>

  List of bookmarks:<br/>
	<display:table name="bookmarkList" id="bookmark" class="mars" export="true" sort="list" pagesize="20" requestURI="list.do">
	  <display:column title="Edit" href="edit.do" paramId="id" paramProperty="id">
			Edit
	  </display:column>
	  <display:column title="Delete">
	  	<c:if test="${bookmark.userData.id == sessionUserId}">
	  		<form action="delete.do" method="POST" onsubmit="return verifyDeleteBookmark()">
				<input type="hidden" name="id" value="${bookmark.id}"/>
	  			<input class='ibutton' type="submit" name="submit.delete" value="Delete"/>
	  		</form>
	  	</c:if>
	  </display:column>
	  <c:if test="${not empty showUser}">
	  	<display:column property="userData.userLogin" title="User" sortable="true" headerClass="sortable" href="user.do" paramId="id" paramProperty="userData.id"/>
	  </c:if>
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
		<display:column title="Add">
		  <c:if test="${bookmark.userData.id != sessionUserId}">
			<input class='ibutton' type='button' onclick='BookmarkAJAX.addBookmarkToCurrentUser("${bookmark.id}", reply${bookmark.id});' value='Add'  title='Add bookmark'/>
			<script type='text/javascript'>
				    var reply${bookmark.id} = function(data)
				    {
				      if (data != null && typeof data == 'object') alert(DWRUtil.toDescriptiveString(data, 2));
				      else 
				      {
				      	if (data == true) DWRUtil.setValue('reply${bookmark.id}', 'Added');
				      	else DWRUtil.setValue('reply${bookmark.id}', 'Not added');
				      }
				    }
			  </script>	
			  <span id='reply${bookmark.id}' class='reply'></span>
  			</c:if>
		</display:column>
	</display:table>
  <c:if test="${not empty deleteFailed}">
  <FONT color="red">
  	Delete failed: Bookmark not found.<br/>
  </FONT>
  </c:if>

<%--  
	<c:forEach var="bookmark" items="${bookmarkList}">
		<c:out value="${bookmark.id}"/> - <a href="<c:out value="${bookmark.url}"/>">
		<c:out value="${bookmark.url}"/></a><br/>
	</c:forEach>
--%>
  </body>
</html>
