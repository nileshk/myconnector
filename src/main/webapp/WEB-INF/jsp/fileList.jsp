<%@ include file="include/top.jsp" %>

  List of files:<br/>
	<display:table name="fileList" id="file" class="mars" export="true" sort="list" pagesize="20" requestURI="fileList.do">
	  <display:column title="Download" href="fileDownload.do" paramId="id" paramProperty="id">
			Download
	  </display:column>
	  <display:column title="Delete" href="fileDelete.do" paramId="id" paramProperty="id">
			Delete
	  </display:column>
	  <display:column property="fileName" title="Name" sortable="true" />
	  <display:column property="fileSize" title="Size" sortable="true" />
	  <display:column property="fileType" title="Type" sortable="true" />
	  <display:column property="fileDescription" title="Description" sortable="true" />
	</display:table>

  </body>
</html>
