<?xml version="1.0" encoding="UTF-8" ?>

<%-- IMPORT --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- VARIABLES --%>
<%
	String authentificationFailed = (String) request.getAttribute("errorLogin");
%>

<%-- HTML5 --%>
<!DOCTYPE html>
<html>

<%-- HEAD --%>
<jsp:include page="head.jsp" />

<%-- BODY --%>
<body>
	<div id="main_wrapper">
	<%-- HEADER --%>
	<header>
		<h1>CRM 365 Authentification</h1>
	</header>

	<%-- CONTENU --%>
	<section id="sectionLogin">
	
		<%-- FORMULAIRE D'AUTHENTIFICATION --%>
		<form action="j_spring_security_check" method="post">

			<div class="align">
				<label for="j_username">Login</label> 
				<input id="j_username" name="j_username" size="20" maxlength="50" type="text" />
			</div>
			<div class="align">
				<label for="j_password">Password</label> 
				<input id="j_password" name="j_password" size="20" maxlength="50" type="password" />
			</div>
			<div id="loginFormButton" class="alignButton">
				<input id="login_button" class="crmButton loginButton" value="login" type="submit" /> 
				<input value="reset" class="crmButton loginButton" type="reset" />
			</div>

		</form>
		<%
			if (authentificationFailed != null) {
		%>
			<p id="loginInvalidMessage" class="ui-state-error"><%=authentificationFailed%></p>
		<%
			}
		%>
	</section>

	<%-- FOOTER --%>
	<jsp:include page="footer.jsp" />
	</div>
</body>
</html>