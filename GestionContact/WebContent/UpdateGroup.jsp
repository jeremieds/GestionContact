<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<head>
<title><bean:message key="group.update" /></title>
<jsp:include page="/head.jsp" />
<html:base />
</head>

<body bgcolor="white">
<jsp:include page="/header.jsp" />
	<html:form action="/UpdateGroup">
		
		<div class="subscribe_form no-top">
			<div class="container">
				<div class="row ">
					<div class="col-lg-12">
						<div class="subscribe_form_iner">
							<div class="form-row align-items-center justify-content-center">
								<div class="col-md-12 col-lg-3">
									<h3>
										<bean:message key="main.updategroup.link" />
									</h3>
								</div>

								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="groupName" class="form-control"
										placeholder="Name of group">
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="newGroupName" class="form-control"
										placeholder="New name of group">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-row align-items-center justify-content-center">
			<div class="col-12 col-sm-6 col-md-4 col-lg-3">
				<input type="submit" class="btn_1" value="submit">
			</div>
		</div>
	</html:form>
</body>
</html:html>