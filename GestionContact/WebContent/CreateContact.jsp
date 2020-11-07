<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>

<html:html>
<head>
<title><bean:message key="add.contact" /></title>
<jsp:include page="/head.jsp" />
<html:base />
</head>
<body bgcolor="white">
	<jsp:include page="/header.jsp" />
	<html:form action="/AddContact">
		<html:errors />

		<div class="subscribe_form no_top">
			<div class="container">
				<div class="row ">
					<div class="col-lg-12">
						<div class="subscribe_form_iner">
							<div class="form-row align-items-center justify-content-center">
								<div class="col-md-12 col-lg-3">
									<h3>Identity</h3>
								</div>
							$
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="nom" class="form-control"
										placeholder="Lastname">
								</div>
								
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="prenom" class="form-control"
										placeholder="Firstname">
								</div>
								<div class="col-12 col-sm-6 col-md-4 col-lg-3">
									<input type="text" name="mail" class="form-control"
										placeholder="Mail">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="subscribe_form no_top">
				<div class="container">
					<div class="row ">
						<div class="col-lg-12">
							<div class="subscribe_form_iner">
								<div class="form-row align-items-center justify-content-center">
									<div class="col-md-12 col-lg-3">
										<h3>Adress</h3>
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<input type="text" name="street" class="form-control"
											placeholder="Street">
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<input type="text" name="city" class="form-control"
											placeholder="City">
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<input type="text" name="zip" class="form-control"
											placeholder="Zip">
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<input type="text" name="country" class="form-control"
											placeholder="Country">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="subscribe_form no_top">
				<div class="container">
					<div class="row ">
						<div class="col-lg-12">
							<div class="subscribe_form_iner">
								<div class="form-row align-items-center justify-content-center">
									<div class="col-md-12 col-lg-3">
										<h3>Téléphone</h3>
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<select name="type_number" class="form-control">
											<option value="cellphone" selected>Portable</option>
											<option value="phone">phone</optio>
											<option value="pro_phone">pro phone</option>
										</select>
									</div>
									<div class="col-12 col-sm-6 col-md-4 col-lg-3">
										<input type="text" name="number" class="form-control"
											placeholder="Number">
									</div>
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