<%@ include file="include/top.jsp" %> 
<body>
<center>
<h2>Welcome to MyConnector</h2>
<p>Number of bookmarks: <c:out value="${bookmarkCount}"/></p>
<p>Number of unique bookmarks: <c:out value="${pageListCount}"/></p>
<p>Number of pages cached: <c:out value="${pageCacheCount}"/></p>
<br><br>
  <c:if test="${empty username}">
	  <form action="<c:url value="home.do"/>" method="post">		  
		<table class="inputform" border="0">
		<div id="topleft">
			<tr>
				<td>Username:</td>
				<td>
					<spring:bind path="command.username">
						<input type="text" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"/>
					</spring:bind>
				</td>			
				<td><springx:error property="command.username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>
					<spring:bind path="command.password">
						<input type="password" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"/>
					</spring:bind>
				</td>
				<td><springx:error property="command.password"/></td>
			</tr>			
			<tr>
				<td></td>
				<td>
					<input class="input-button" type="submit" name="submit.login" value="Submit"/>
				</td>
			</tr>
			<tr>			
				<td>
					<spring:bind path="command.remember"> 
						<input type="hidden" name="_<c:out value="${status.expression}"/>">
						<input type="checkbox" name="<c:out value="${status.expression}"/>" value="true"
						<c:if test="${status.value}">checked</c:if>/>
					</spring:bind>
					Remember me
				</td>
				<td></td>
			</tr>
		</div>
		</table>	
	  </form>
  </c:if>
  <c:if test="${not empty sessionUserId}">
  	Logged in: ${username}<br><br>
  	<a href="profile.do?id=${sessionUserId}">View my profile</a>
  </c:if>
</html>
<app:focus/>