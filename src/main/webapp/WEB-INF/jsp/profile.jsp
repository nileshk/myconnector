<%@ include file="include/taglib.jsp" %>
<app:top>
<c:if test="${userData.id == sessionUserId}">
  <script>
	function verifyDeleteFriend() {
	    var x=window.confirm("<spring:message code="friend.delete.confirm"/>")
		if (x) {
			return true;
		} else {
			return false;
		}
	}
  </script> 
</c:if>
</app:top>
${userData.userLogin}'s profile<br>

	<display:table name="userData.friendsById" id="friend" class="mars" export="false" sort="list" pagesize="20" requestURI="profile.do">
	  <display:column property="userDataByFriendId.userLogin" title="Friend" group="1" sortable="true" headerClass="sortable" href="profile.do" paramId="id" paramProperty="userDataByFriendId.id"/>
	  <display:column title="Delete">
	  	<c:if test="${userData.id == sessionUserId}">
	  		<form action="friendDelete.do" method="POST" onsubmit="return verifyDeleteFriend()">
				<input type="hidden" name="id" value="${friend.userDataByFriendId.id}"/>
	  			<input class='ibutton' type="submit" name="submit.delete" value="Delete"/>
	  		</form>
	  	</c:if>
	  </display:column>
	</display:table>


  List of bookmarks:<br/>
	<display:table name="bookmarkList" id="bookmark" class="mars" export="true" sort="list" pagesize="20" requestURI="profile.do">
	  <c:if test="${not empty showUser}">
	  	<display:column property="userData.userLogin" title="User" sortable="true" headerClass="sortable" href="user.do" paramId="id" paramProperty="userData.id"/>
	  </c:if>
	  <display:column title="URL" sortable="true" headerClass="sortable">
			<a href="<c:out value="${bookmark.url}"/>">
				${fn:substring(bookmark.url, 0, 50)}
			</a>
	  </display:column>
	  <display:column property="title" title="Title" sortable="true" headerClass="sortable"/>
		<display:column title="Add Date" sortable="true" headerClass="sortable">
			<fmt:formatDate value="${bookmark.addDate}" pattern="yyyy-MM-dd"/>
		</display:column>
<%--	<display:column property="keywords" title="Keywords" sortable="true" headerClass="sortable"/> --%>
	</display:table>

  </body>
</html>
