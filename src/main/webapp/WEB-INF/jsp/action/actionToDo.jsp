<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.miage.crm365.model.entity.Task" %>

<%-- Variables --%>
<%
	Map<Task, String> tasksList   = (Map<Task, String>) request.getAttribute("tasksList");
	
	String workflowAssignStatus = (String) request.getAttribute("workflowAssignStatus");
	String workflowDoneStatus 	= (String) request.getAttribute("workflowDoneStatus");
	String errorWorkflowStatus 	= (String) request.getAttribute("errorWorkflowStatus");
%>
<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#actionToDo">Action list</a></li>
	</ul>
<section id="actionToDo">
<h1><spring:message code="actionToDoTitle"/></h1>

<%if( workflowAssignStatus != null) { %>
	<p id="workflowAssignStatus"><%= workflowAssignStatus %></p>
<%}%>
<%if( workflowDoneStatus != null) { %>
	<p id="workflowDoneStatus"><%= workflowDoneStatus   %></p>
<%}%>
<%if(errorWorkflowStatus != null) { %>
	<p id="errorWorkflowStatus"><%= errorWorkflowStatus %></p>
<%}%>

<table class="dataTables">
  <thead>
  <tr>
    <th>ID</th>
    <th><spring:message code="workflow.task.creationDate" /></th>
    <th><spring:message code="workflow.task.description" /></th>
    <th><spring:message code="workflow.task.user" /></th>
    <th><spring:message code="workflow.task.customer" /></th>
    <th>Book</th>
    <th>Done</th>
  </tr>
  </thead>
  <tbody>
  <%
  	if (tasksList != null) {
  	
  		for( Map.Entry<Task, String> task : tasksList.entrySet() ) {
  %>
  		<tr>
  			<% Long currentTaskId = task.getKey().getTaskId(); %>
    		<td><%= currentTaskId %></td>
    		<span style="visibility: hidden; display: none;"><%=currentTaskId%></span>
    		
    		<td><%= task.getKey().getCreationDate() %></td>
    		<span style="visibility: hidden; display: none;"><%=task.getKey().getCreationDate()%></span>
    		
    		<td><%= task.getValue() %></td>
  			<span style="visibility: hidden; display: none;"><%=task.getValue()%></span>
  			
  			<td><%= task.getKey().getUsername() %></td>
  			<span style="visibility: hidden; display: none;"><%=task.getKey().getUsername()%></span>
  			
  			<td>
  				<a href="#" name="customerDetail" ><%= task.getKey().getCustomerId() 	%></a>
  				<input  type="hidden" 		value="<%= task.getKey().getCustomerId() %>" />
  			</td>
  			<td>
  				<input id="bookTask" name="bookTask" type="submit" value="<spring:message code="workflow.task.bookTask" />"/>
  				<input id="taskId"   			       type="hidden" value="<%= currentTaskId %>" />
  			</td>
  			<td>
  				<input id="taskDone" name="taskDone" type="submit" value="<spring:message code="workflow.task.done" />"/>
  				<input id="taskId"   				   type="hidden" value="<%= currentTaskId %>" />
  			</td>
  		</tr>
  		
  <%
  		}
  	}
  %>
  </tbody>
</table>
</section>
</div>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">

	$('input[name="bookTask"]').click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"bookTask.workflow",
			data: 		{taskId: $(this).next().val()}
		});
	});
	
	$('input[name="taskDone"]').click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"taskDone.workflow",
			data: 		{taskId: $(this).next().val()}
		});
	});
	
	$("a[name='customerDetail']").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"customerDetail.customer",
			data: 		{
						customerId: 			$(this).next().val()	
						}
			  });
	});
	
	$("#workflowAssignStatus").addClass("ui-state-highlight");
	$("#workflowDoneStatus").addClass("ui-state-highlight");
	$("#errorWorkflowStatus").addClass("ui-state-error");
	$('.dataTables').dataTable( {"bJQueryUI": true} );	
</script>