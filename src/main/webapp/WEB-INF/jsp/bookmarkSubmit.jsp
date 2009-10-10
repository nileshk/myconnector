<%@ include file="include/top.jsp" %>
<CENTER>
		<h2>Create Bookmark</h2><br/>
		<form action="<c:url value="bookmarkSubmit.do"/>" method="post">
			<c:if test="${not empty param.popup || not empty popup}">
				<input type="hidden" name="popup" value="1"/>
			</c:if>
		
			<table border="0" cellspacing="0" width="100%">
				<tr><td>URL:</td>
				<td>
					<spring:bind path="command.url">
						<input type="text" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"
							size="120"/>
					</spring:bind>
				</td>
			<tr><td/>
			<tr><td>Title:</td>
				<td>
					<spring:bind path="command.title">
						<input type="text" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"
							size="120"/>
					</spring:bind>
				</td>
			<tr><td/>
			<tr><td>Keywords:</td>
				<td>
					<spring:bind path="command.keywords">
						<input type="text" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"
							size="120"/>
					</spring:bind>
				</td>
			<tr><td/>

			<tr><td>Private:</td>
				<td>
					<spring:bind path="command.viewable">
						<select
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"
							>
							<option value="0">No</option>
							<option value="1">Yes</option>
						</select>
					</spring:bind>
				</td>
			<tr><td/>

			<td>
				<input type="submit" name="submit.save" value="Save"/>
			</td></tr>
			</table>
		</form>
</CENTER>
