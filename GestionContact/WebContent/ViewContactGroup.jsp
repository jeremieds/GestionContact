<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>



<html:html>
<head>
<title><bean:message key="menu.page.title" /></title>
<jsp:include page="/head.jsp" />
</head>
<body>
	<jsp:include page="/header.jsp" />
	<h4>Contact : </h4>
	<jsp:useBean id="ContactGroup" scope="session"
		type="java.util.ArrayList" />
	<!-- feature_post start-->
	<section class="all_post section_padding">
		<div class="container">
			<div class="row">
				<div class="col-12 col-sm-6 col-md-4 col-lg-3"></div>
				<div class="col-lg-4">
					<div class="sidebar_widget">

						<div class="single_sidebar_wiget">
							<div class="sidebar_tittle">
								<h3>List contact</h3>
							</div>
							<div class="single_catagory_item category">
								<ul class="list-unstyled">
									<%
										for (int i = 0; i < ContactGroup.size(); i++) {
									%>
									<li><%=ContactGroup.get(i)%></li>
									<%
										}
									%>

								</ul>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>



</body>

</html:html>