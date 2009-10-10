<c:if test="${empty param.popup && empty popup}">
<center>
<table class="menu">
	<tr>
		<td><center>
			<a href="home.do">Home</a>
		</center></td>
		<td><center>
			<a href="profile.do">Profile</a>
		</center></td>
		<td><center>
			<a href="users.do">User List</a>
		</center></td>
		<td><center>
			<a href="userList.do">User Admin</a>
		</center></td>
		<td><center>
			<a href="userConfig.do">Config</a>
		</center></td>
		<td><center>
			<a href="logout.do">Logout</a>
		</center></td>
	</tr>
	<tr>
		<td><center>
			<a href="search.do">Search Bookmarks</a>
		</center></td>
		<td><center>
			<a href="bookmarkListCurrentUser.do">My Bookmarks</a>
		</center></td>
		<td><center>
			<a href="list.do">Bookmark List</a>
		</center></td>
		<td><center>
			<a href="bookmarkSubmit.do">Bookmark Submit</a>
		</center></td>
		<td><center>
			<a href="bookmarkAdmin.do">Bookmark Admin</a>
		</center></td>
	</tr>
	<tr>
		<td><center>
			<a href="fileUpload.do">File Upload</a>
		</center></td>
		<td><center>
			<a href="fileList.do">File List</a>
		</center></td>
		<td><center>
			<a href="releaseList.do">Release List</a>
		</center></td>
	</tr>
	<tr>
		<td><center>
			<a href="todoLists.do">Todo lists</a>
		</center></td>	
		<td><center>
			<a href="todoList.do">Todo</a>
		</center></td>	
		<td><center>
			<a href="todoListAdvanced.do">Todo Advanced</a>
		</center></td>	
		<td><center>
			<a href="timesheet.do">Timesheet</a>
		</center></td>	
		<td><center>
			<a href="tsActivityList.do">Activities</a>
		</center></td>	
		<td><center>
			<a href="tsCustomerList.do">Customers</a>
		</center></td>			
	</tr>
</table>
</center>
</c:if>