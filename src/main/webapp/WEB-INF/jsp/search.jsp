<%@ include file="include/top.jsp" %>
<center>
	<h2>Search Bookmarks</h2></br/>
	<form action="<c:url value='search.do'/>" method="post">	
		<table class="inputform" border="0">
			<tr>
				<td>
					<spring:bind path="command.search">
						<input type="text" size=65
							name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>"/>
					</spring:bind>
				</td>
				<td><springx:error property="command.search"/></td>
			</tr>
			<tr>
				<td>
					<input class="input-button" type="submit" name="submit.search.my" value="Search My Bookmarks"/>
					<input class="input-button" type="submit" name="submit.search.network" value="Search My Network"/>
					<input class="input-button" type="submit" name="submit.search.all" value="Search All"/>
				</td>
				<td></td>
			</tr>			
		</table>
	</form>
</center>
<app:focus/>