<%@ include file="include/top.jsp" %>
<center>
	<h2>Search Bookmarks</h2></br/>

	<form action="<c:url value='search.do'/>" method="post">
		<table class="inputform" border="0">
			<tr>				
				<td>					
					<input type="text" size=65 name="search" value="${query}"/>
					
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<input class="input-button" type="submit" name="submit.search.my" value="Search My Bookmarks"/>
					<input class="input-button" type="submit" name="submit.search.network" value="Search My Network"/>
					<input class="input-button" type="submit" name="submit.search.all" value="Search All"/>
				</td>

			</tr>			
		</table>
	</form>
</center>
<!--<table width=100% border=0 cellpadding=0 cellspacing=0 bgcolor=#e5ecf9>-->
<table width=100% class="inputform">
<tr><td align="right" nowrap><font size="-1">${fn:length(results)} results found (${timeElapsed} seconds)</font></td></tr>
</table>
<br>
<c:if test="${not empty results}">
	<c:if test="${empty compactList}">
		<c:forEach var="result" items="${results}">	
			<a href="${result.compId.page.url}">${result.compId.page.title}</a><br>
			<font size="-1"><font color="#008000">${result.compId.page.url}</font> - 
			<a href="cacheView.do?id=${result.compId.page.id}">Cached</a></font><br><br>
		</c:forEach>
	</c:if>
	<c:if test="${not empty compactList}">
		<c:forEach var="result" items="${results}">	
			<a href="${result.compId.page.url}">${result.compId.page.url}</a><br>
		</c:forEach>	
	</c:if>
</c:if>
<%--
<c:if test="${byUser != null}">
	<c:if test="${not empty results}">
		<c:forEach var="result" items="${results}">	
			<a href="${result.url}">${result.url}</a><br>
		</c:forEach>
	</c:if>
</c:if>
--%>
<app:focus/>