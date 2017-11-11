<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%	
	Integer tasksGenerated = (Integer) request.getAttribute("tasksGenerated");
%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#taskGenerated">TACHE GENEREES</a></li>
	</ul>
	<section id="taskGenerated">
		<%-- Nombre de taches generees suite a l'appui sur le bouton generate task --%>
		<%if (tasksGenerated != null){ %>	
			<div class="infoNotification" style="color: green;">
	    		<%=tasksGenerated%> <spring:message code="action.generateTasks.tasksGenerated"/>  
	    	</div>	  
	    <%}else{%>
			<p class="errorNotification" style="color: red;">AUCUNE TACHE GENEREE</p>
	    <%}%>	
	</section>
</div>


<script type="text/javascript" charset="utf-8">
	$(".infoNotification").addClass("ui-state-highlight");
	$(".errorNotification").addClass("ui-state-error");
</script>