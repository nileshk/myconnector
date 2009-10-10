<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib tagdir="/WEB-INF/tags/springx" prefix="springx" %>
<%@ taglib tagdir="/WEB-INF/tags/app" prefix="app" %>
<html>
	<head>
		<title><spring:message code="application.name"/></title>
		<link rel="stylesheet" type="text/css" href="css/screen.css">
		<jsp:doBody/>
	</head>
	
<body>

<%@ include file="/WEB-INF/jsp/include/menu.jsp" %>

<springx:errors name="command"/>

<c:if test="${empty dateTimePattern}">
	<c:set var="dateTimePattern" value="yyyy-MM-dd HH:mm"/>
</c:if>
<c:if test="${empty datePattern}">
	<c:set var="datePattern" value="yyyy-MM-dd"/>
</c:if>
<c:if test="${empty timePattern}">
	<c:set var="timePattern" value="HH:mm"/>
</c:if>
