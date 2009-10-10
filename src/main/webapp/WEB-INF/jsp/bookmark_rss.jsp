<%@ page contentType="application/xml; charset=UTF-8" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><?xml version="1.0" encoding="UTF-8"?>

<rdf:RDF
 xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
 xmlns="http://purl.org/rss/1.0/"
 xmlns:taxo="http://purl.org/rss/1.0/modules/taxonomy/"
 xmlns:dc="http://purl.org/dc/elements/1.1/"
 xmlns:syn="http://purl.org/rss/1.0/modules/syndication/"
 xmlns:admin="http://webns.net/mvcb/"
>

<channel rdf:about="http://localhost:8080/myconnector/bookmarkRSS.do?user=${userLogin}">
<title>www.myconnector.com/${userLogin}</title>
<link>http://localhost:8080/myconnector/bookmarkRSS.do?user=${userLogin}</link>
<description></description>
<items>
 <rdf:Seq>
<c:forEach var="bookmark" items="${bookmarks}"> 
  <rdf:li rdf:resource="${bookmark.url}" />
</c:forEach>
 </rdf:Seq>
</items>
</channel>

<c:forEach var="bookmark" items="${bookmarks}">
<item rdf:about="${bookmark.url}">
<title>${bookmark.title}</title>
<link>${bookmark.url}</link>
<dc:creator>${bookmark.userData.userLogin}</dc:creator>
<dc:date>2005-04-03T21:19:00Z</dc:date>
<dc:subject>${bookmark.keywords}</dc:subject>
</item>
</c:forEach>

</rdf:RDF>
