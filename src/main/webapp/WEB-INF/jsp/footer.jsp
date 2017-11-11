<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- Import --%>
<%@page import="com.miage.crm365.utils.CRM365Constants"%>
<%@page import="com.miage.crm365.utils.DateUtil"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- Variables --%>

<%-- HTML5 --%>
<footer>
  <p id="copyright">© Copyright CRM365 - <%=DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR)%></p>
  <p id="appVersion">Version : 3.0 </p>
  <p id="languages"><spring:message code="test.language" /></p>
</footer>

<%-- Javascript --%>
<script type="text/javascript" charset="utf-8">
	
	/* Utililsees pour remettre l'onglet selectionne apres rafrichissement ajax */
	var articleTab;
	var selectedBeforeAjax;

	$(".crmButton").button();
	
	$("article, aside").ajaxSend(function() {
		$(this).fadeOut();
		
		selectedBeforeAjax = $("article #articleTab").tabs('option', 'selected');
	});
	
	
	/*
	 * Recupération réponse et affichage article
	 */
	$("article, aside").ajaxSuccess(function(e, xhr, settings) {
		if ( (settings.url == 'search.customer') || (settings.url == 'searchForm.customer') || (settings.url == 'customerDetail.customer') || (settings.url == 'updateFreeValCustomerRow.customer'))
			$("aside").html(xhr.responseText);
		else 
			$("article").html(xhr.responseText);	
	});
	
	/*
	 * Code execute apres reponse requete ajax recue
	 * Rafraichissement des boutons pour style
	 */
	$("article, aside").ajaxComplete(function() {
		$(this).fadeIn();
		
		$('input[type="submit"], input[type="button"]').addClass("crmButton");		
		$(".crmButton").button();
		
		articleTab = $("article #articleTab").tabs();
		$("aside #articleTab").tabs();
		
		articleTab.tabs('select', selectedBeforeAjax); 
		
		$(".infoNotification").addClass("ui-state-highlight");
		$(".errorNotification").addClass("ui-state-error");
	});
	
	/*
	 * Affichage message access interdit si pas les droits
	 */
	$("article, aside").ajaxError(function(e, xhr, settings, exception) {
		if (xhr.status == 403)
			$(this).html("<div id='articleTab'><ul><li><a href='#secureTab'>SECURE PAGE</a></li></ul><section id='secureTab'><p id='infoError'>You cannot access to this page</p></section></div>");
		else
			$(this).html("<div id='articleTab'><ul><li><a href='#errorTab'>ERROR</a></li></ul><section id='errorTab'><p id='infoError'>Internal application error</p></section></div>");
			
		$("#infoError").addClass("ui-state-error");
		articleTab = $("#articleTab").tabs();
	});
	
	
	
	/*
	 * Notifications de succes ou de failure
	 */
	$(".infoNotification").addClass("ui-state-highlight");
	$(".errorNotification").addClass("ui-state-error");
</script>