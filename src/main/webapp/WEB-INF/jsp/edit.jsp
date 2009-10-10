<%@ include file="include/top.jsp" %>
<CENTER>
		<h2>Edit Bookmark</h2><br/>
		<form action="<c:url value="edit.do"/>" method="post">
			<table border="0" cellspacing="0" width="100%">

			<spring:bind path="command.id">
				<input type="hidden" 
					name="<c:out value="${status.expression}"/>" 
					value="<c:out value="${status.value}"/>"/>
			</spring:bind>

<%--				<tr><td>User:</td>
				<td>
					<spring:bind path="command.user">
						<input type="text" 
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"/>
					</spring:bind>
				</td>--%>
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
