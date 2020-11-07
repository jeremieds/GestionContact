<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html:html>

<head>

<title><bean:message key="success" /></title>
<jsp:include page="/head.jsp" />
</head>

<body>
<jsp:include page="/header.jsp" />
Success ! 
<br>
<c:if test="${sessionScope.action == 'add'}">
       <bean:message key="contact.add" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'delete'}">
       <bean:message key="contact.delete" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'update'}">
       <bean:message key="contact.update" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'read'}">
    	${sessionScope.readContact}
       <bean:message key="contact.read" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'createGroup'}">
       <bean:message key="group.create" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'deleteGroup'}">
       <bean:message key="group.delete" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'updateGroup'}">
       <bean:message key="group.update" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'readGroup'}">
       <bean:message key="group.read" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'groupsNames'}">
       <bean:message key="group.groupsNames" />
    </c:if>
	<c:if test="${sessionScope.action == 'addContactGroup'}">
       <bean:message key="contact.addContactGroup" />
    </c:if>
    
    <c:if test="${sessionScope.action == 'deleteContactGroup'}">
       <bean:message key="contact.deleteContactGroup" />
    </c:if>
</body>

</html:html>
