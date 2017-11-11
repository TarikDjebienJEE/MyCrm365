<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- Variables --%>

<%-- HTML5 --%>

<nav id="menu">

	<h1><a><spring:message code="eventGroup" /></a></h1>
	<div>
		<ul>
			<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<li><a name="menuItem"  href="#" id="configuration.event"	  ><spring:message code="eventGroup-manual" /></a></li>
			</sec:authorize>
				<li><a name="menuItem"  href="#" id="manualFileInput.event"   ><spring:message code="eventGroup-automated" /></a></li>
				<li><a name="menuItem"	href="#" id="input.manualEvent"		  ><spring:message code="eventGroup-manualInput" /></a></li>
		</ul>
	</div>
	
	<h1><a href="#"><spring:message code="actionGroup" /></a></h1>
	<div>
		<ul>
			<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<li><a name="menuItem"  href="#" id="configuration.action"	><spring:message code="actionGroup-triggerRules" /></a></li>
			</sec:authorize>
				<li><a name="menuItem"  href="#" id="actionToDo.workflow"	><spring:message code="actionGroup-todo" /></a></li>
		</ul>
	</div>
	
	<sec:authorize ifAnyGranted="ROLE_DECIDOR">
	<h1><a href="#"><spring:message code="reportingGroup" /></a></h1>
	<div>
		<ul>
				<li><a name="menuItem"  href="#" id="event.reporting" 		><spring:message code="reporting-event"  /></a></li>
				<li><a name="menuItem"	href="#" id="action.reporting"		><spring:message code="reporting-action" /></a></li>
		</ul>
	</div>
	</sec:authorize>
	
	<h1><a href="#">CUSTOMER</a></h1>
	<div>
		<ul>
				<li><a name="menuItem"  href="#" id="manualFileInput.customer"   ><spring:message code="customer-file-input" /></a></li>
				<li><a name="menuItem"  href="#" id="configuration.customer"	 ><spring:message code="customer.profile-customization" /></a></li>
		</ul>
	</div>
	
	<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<h1><a href="#"><spring:message code="administrationGroup" /></a></h1>
	<div>
		<ul>
				<li><a name="menuItem"  href="#" id="administrateUser.admin"         ><spring:message code="admin.administrateUser" /></a></li>
				<li><a name="menuItem"  href="#" id="administrateTeam.admin"         ><spring:message code="admin.administrateTeam" /></a></li>
		</ul>
	</div>
	</sec:authorize>
	
</nav>

<%-- JavaScript --%>
<script>
$("#menu").accordion();

/**
 * Fonction qui ferme le menu de gauche
 * @author: Djebien Tarik
 */
$(".hideMenu").live("click",function () {
    $("#menu").toggle(700);
    $(this).removeClass("hideMenu").addClass("showMenu");
    $(this).html("Show Menu");
    $("#sectionMainContent").css("width","100%");
});

/**
 * Fonction qui ouvre le menu de gauche
 * @author: Djebien Tarik
 */
$(".showMenu").live("click",function () {
    $("#menu").toggle(700);
    $(this).removeClass("showMenu").addClass("hideMenu");
    $(this).html("Hide Menu");
    $("#sectionMainContent").css("width","84%");
});

/**
 * Fonction qui charge le contenu des pages dynamiquement à un clic sur le menu
 *
 */
 $('a[name="menuItem"]').click( function() {
	$.ajax({
		type: 		'POST',
		url:  		$(this).attr("id"),
		data: 		{}
	});
});
	
</script>