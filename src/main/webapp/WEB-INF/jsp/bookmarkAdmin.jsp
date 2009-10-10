<%@ include file="include/taglib.jsp" %>
<app:top>
</app:top>
<h2>Bookmark Admin</h2>
<p>Generate the index incrementally without deleting existing data.
Finds new URL bookmarks, stores them in page_list and indexes only these new URL's.
</p>
<form action="<c:url value='bookmarkGenerateIndex.do'/>" method="post">
	<input type="submit" name="submit.generate.incremental" value="Generate Index Incrementally"/>
</form>

<p>Same as above, but only do a maximum of 30 pages in one shot</p>
<form action="<c:url value='bookmarkGenerateIndex.do'/>" method="post">
	<input type="submit" name="submit.generate.incremental.limit" value="Generate Index Incrementally with Limit 30"/>
</form>

<p><br>Other useful functions:<br></p>

<p>Generating the index will do an HTTP request and get a copy of pages for all URLs that exist in the database.
It will generate the search index from those pages.  This is a time-consuming process that should not be executed very often.</p>
<form action="<c:url value='bookmarkGenerateIndex.do'/>" method="post">
	<input type="submit" name="submit.generateindex" value="Generate Index"/>
</form>
<p>Generating the index will use cached pages that already exist in the database.  Doesn't check for new URL's.
It will generate the search index from those pages.  Least expensive index function.</p>
<form action="<c:url value='bookmarkGenerateIndex.do'/>" method="post">
	<input type="submit" name="submit.generateindexfromcache" value="Generate Index From Cache"/>
</form>
<p>Generate the index incrementally, but deletes page_index and recreates an entirely new one.  Good for when indexing algorithm has changed.
</p>
<form action="<c:url value='bookmarkGenerateIndex.do'/>" method="post">
	<input type="submit" name="submit.generate.incremental.newindex" value="Generate Index Incrementally w/ New Index"/>
</form>