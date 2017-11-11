<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%-- Import --%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	
	<%-- Variables --%>
	<%	
		Integer nbRowInsertedEvent = (Integer) request.getAttribute("nbRowInsertedEvent");
		Integer nbRowInsertedCustomer = (Integer) request.getAttribute("nbRowInsertedCustomer");
	%>

<%-- HTML5 --%>
<!DOCTYPE html>
<html>
	<%-- HEAD --%>
	<jsp:include page="head.jsp" />
	
	<%-- BODY --%>
	<body>
	<div id="main_wrapper">
	<%-- HEADER : en-tête --%>
	<jsp:include page="header.jsp" />
	
	<%-- MENU : liens principaux de navigation --%>
	<jsp:include page="menu.jsp" />
	
	<%-- SECTION DE PAGE --%>
	<section id="sectionMainContent">
		
		<%-- ARTICLE INDEPENDANT --%>
		<article>
		</article>
		
		<%-- INFORMATIONS COMPLEMENTAIRES --%>
		<aside>

			<%-- Partie indiquant le resultat de l'importation d'evenements a partir d'un csv --%>	
			<%if (nbRowInsertedEvent != null){ %>	
				<%if( nbRowInsertedEvent > 0){ %>
					<h1><spring:message code="event.automatedImportEventFromCsv.resultat" /></h1>
					<p id="messageSuccessUploadCsv" style="color: green;"> <%=nbRowInsertedEvent%> <spring:message code="event.automatedImportEventFromCsv.rowInserted" /></p>      
				<%}else{%>
					<p id="messageFailureUploadCsv" style="color: red;"><spring:message code="event.automatedImportEventFromCsv.errorInsertFromCsv" /></p>
			    <%}%>
		    <%}%>			
			
			
			<%-- Partie indiquant le resultat de l'importation de customers a partir d'un csv --%>	
			<%if (nbRowInsertedCustomer != null){ %>	
				<%if( nbRowInsertedCustomer > 0){ %>
					<h1><spring:message code="event.automatedImportEventFromCsv.resultat" /></h1>
					<p id="messageSuccessUploadCsv" style="color: green;"> <%=nbRowInsertedCustomer%> <spring:message code="customer.rowInserted" /></p>      
				<%}else{%>
				
					<p id="messageFailureUploadCsv" style="color: red;"><spring:message code="customer.errorInsertFromCsv" /></p>
			    <%}%>
		    <%}%>		

		</aside>
	</section>
	
	<%-- FOOTER : pied de page --%>
	<jsp:include page="footer.jsp" />
	</div>
	
	<%-- Javascript --%>
	<script type="text/javascript" charset="utf-8">
		
		$("#messageSuccessUploadCsv").addClass("ui-state-highlight");
		$("#messageFailureUploadCsv").addClass("ui-state-error");
	</script>
</body>
</html>