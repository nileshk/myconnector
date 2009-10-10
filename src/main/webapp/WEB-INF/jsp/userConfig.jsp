<%@ include file="include/taglib.jsp" %>
<app:top>
	<link rel="alternate" type="application/rss+xml" title="RSS" href="bookmarkRSS.do?user=${username}" />
</app:top>
<p>
Drag one or more of the following bookmarklets onto your bookmark toolbar:<br><br>
<%-- TODO: don't hardcode base URL --%>
<a href="javascript:location.href='http://localhost:8080/myconnector/bookmarkSubmit.do?url='+encodeURIComponent(location.href)+'&title='+encodeURIComponent(document.title)">Bookmark this</a> (without popup)<br><br>
<a href="javascript:q=location.href;p=document.title;void(open('http://localhost:8080/myconnector/bookmarkSubmit.do?popup=1&url='+encodeURIComponent(q)+'&title='+encodeURIComponent(p),'myconnector', 'toolbar=no,width=1000,height=250'));">Bookmark this</a> (with popup)<br>
</p>