<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
	
	<header class="main_menu">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12">
					<nav class="navbar navbar-expand-lg navbar-light">
						<a class="navbar-brand" href="Menu.do" disabled="disabled"> <bean:message key="main.page.menu" />
						</a>
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>

						<div
							class="collapse navbar-collapse main-menu-item justify-content-center"
							id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item dropdown">
									<a	href="#" class="nav-link dropdown-toggle" id="navbarDropdown"
										role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> <bean:message key="main.menucontact.link" /> 
									</a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="ContactCreation.do"><bean:message
						key="main.addcontact.link" /></a> 
										<a class="dropdown-item" href="ContactUpdate.do"><bean:message
						key="main.updatecontact.link" /></a>
										<a class="dropdown-item" href="ContactDelete.do"><bean:message
						key="main.deletecontact.link" /></a>
										<a class="dropdown-item" href="ContactRead.do"><bean:message key="main.readcontact.link" /></a>
									</div>
								</li>
								
								<li class="nav-item dropdown">
									<a href="MenuGroup.do" class="nav-link dropdown-toggle" id="navbarDropdown2" 
									   role="button" data-toggle="dropdown" aria-haspopup="true"
									   aria-expanded="false"> <bean:message key="main.menugroup.link" />
									</a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="GroupCreation.do"><bean:message
						key="main.creategroup.link" /></a> 
										<a class="dropdown-item" href="GroupDelete.do"><bean:message
						key="main.deletegroup.link" /></a>
										<a class="dropdown-item" href="GroupUpdate.do"><bean:message
						key="main.updategroup.link" /></a>
									</div>
								</li>
								<li class="nav-item"><a href="MenuGroupView.do" class="nav-link"><bean:message
				key="main.menugroupview.link" /></a>
								</li>
							</ul>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>