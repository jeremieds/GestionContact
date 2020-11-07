<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<head>
<title><bean:message key="update.contact" /></title>
<jsp:include page="/head.jsp" />
<html:base />
</head>
<jsp:include page="/header.jsp" />
<body bgcolor="white">
	<html:form action="/UpdateContact">
		<html:errors />
		<div class="subscribe_form no-top">
			<div class="container">
				<div class="row ">
					<div class="col-lg-12">
						<div class="subscribe_form_iner">
							<div class="form-row align-items-center justify-content-center">
								<div class="col-md-12 col-lg-3">
									<h3>
										<bean:message key="update.contact" />
									</h3>
								</div>

								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="mail" class="form-control"
										placeholder="Mail">
								</div>
								<p class="txt-form"> Value to update :</p>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<select name="selection" class="form-control">
										<option value="lastname" selected>Lastname</option>
										<option value="firstname">Firstname</option>
									</select>
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="modif" class="form-control"
										placeholder="New value">
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