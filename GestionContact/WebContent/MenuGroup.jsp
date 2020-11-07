<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
	<head>
	<title><bean:message key="group.page.title" /></title>
	<jsp:include page="/head.jsp" />
	</head>
	<body>
	<jsp:include page="/header.jsp" />
		<h1>
			<bean:message key="group.page.menu" />
		</h1>
		<h4>
			<a href="GroupCreation.do"><bean:message
					key="main.creategroup.link" /></a>
		</h4>
		<h4>
			<a href="GroupDelete.do"><bean:message
					key="main.deletegroup.link" /></a>
		</h4>
		<h4>
			<a href="GroupUpdate.do"><bean:message
					key="main.updategroup.link" /></a>
		</h4>
	</body>
</html:html>