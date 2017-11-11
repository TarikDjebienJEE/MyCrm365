<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<%-- HTML5 --%>
<header>
	<div id="logoApp">
		<img id="crmLogo" src="<%=request.getContextPath()%>/CharteGraphiqueCRM365/images/logos/logo_icon.png" alt="CRM365 Logo" />
	</div>
	<div id="titre_principal">
		<h1>CRM365</h1>
		<div id="userInfos">
			<h2 id="connectionInfo">Connected as <sec:authentication property="principal.username"/></h2>
		</div>
		
	</div>
	
	<nav id="navigator">
		<ul>
			<li><span class="hideMenu"><spring:message code="hideMenu" /></span></li>
			<li><span><a name="menuItem"  href="#" id="generateTasks.action"    ><spring:message code="action.generateTasks" /></a></span></li>
			<li><span id="logout"><a href="j_spring_security_logout">Déconnexion</a></span></li>
		</ul>
	</nav>
	<div id="search">
			<h2><spring:message code="customer.help.search"/></h2>
			<input id="searchInput" type="text" />
			<input id="searchSubmit" type="submit" class="crmButton" value="<spring:message code='search' />" />
	</div>
</header>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">

	$("#searchSubmit").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"searchForm.customer",
			data: 		{
						searchInput: 			$("#searchInput").val()	
						}
			  });
	});
	
</script>	