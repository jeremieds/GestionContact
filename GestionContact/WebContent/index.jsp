<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<head>
<title><bean:message key="login.contact" /></title>
<jsp:include page="/head.jsp" />
<html:base />
</head>
<body bgcolor="white">

	<html:form action="/Login">
		<html:errors />
		<div class="subscribe_form padding_top margin_top">
			<div class="container">
				<div class="row ">
					<div class="col-lg-12">
						<div class="subscribe_form_iner">
							<div class="form-row align-items-center justify-content-center">
								<div class="col-md-12 col-lg-3">
									<h3><bean:message key="main.login.link" /> </h3>
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="login" class="form-control"
										placeholder="Login">
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="password" name="password" class="form-control"
										placeholder="Password">
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3 no-top">
									<input type="submit" class="btn_1" value="Valider">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</html:form>

</body>
</html:html>