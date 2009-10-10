<%@ include file="include/top.jsp" %>

<form name="form" action="tsCustomerEdit.do" method="POST">

<table>
	<springx:id />
	<springx:row property="command.name" code="tsCustomer.name"/>
	<springx:row property="command.abbreviation" code="tsCustomer.abbreviation"/>
	<springx:submitRow/>
</table>
