<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@page import="com.miage.crm365.utils.DateUtil"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page import="com.miage.crm365.model.entity.EventType" %>
<%@page import="com.miage.crm365.model.entity.EventParameter" %>
<%@page import="com.miage.crm365.utils.CRM365Constants"%>

<%-- Variables --%>
<%
	String createEventTypeStatus = (String) request.getAttribute("createEventTypeStatus");
	String errorEventTypeStatus = (String) request.getAttribute("errorEventTypeStatus");
	String createEventParameterStatus = (String) request.getAttribute("createEventParameterStatus");
	String infoUnsetParameters = (String) request.getAttribute("infoUnsetParameters");
  
	List<EventType> eventTypesAvailable = (List<EventType>) request.getAttribute("eventTypesAvailable");
	String eventTypesUnavailable = (String) request.getAttribute("eventTypesUnavailable");
	Map<EventType, List<EventParameter>> eventsConfiguration = (Map<EventType, List<EventParameter>>) request.getAttribute("eventsConfiguration");
%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#eventsConfiguration">EVENT CONFIGURATION</a></li>
		<li><a href="#createEventType">EVENT_TYPE Creation</a></li>
		<li><a href="#createEventParameter">EVENT_PARAMETER Creation</a></li>
	</ul>
	
<%-- CONFIGURATION --%>
<section id="eventsConfiguration">
<h1>Configuration</h1>

<table id="eventsConfigTable" class="dataTables">
<thead>
	<tr>
		<th>Event type</th>
		<th>Parameters</th>
	</tr>
</thead>
<tbody>
<%
   if (eventsConfiguration != null) {
	for (Map.Entry<EventType, List<EventParameter>> entry : eventsConfiguration.entrySet()) {
%>
	<tr>
		<td>
			<%= entry.getKey().getEventTypeName()   %>
		</td>
		<td>
	<% 
		if (entry.getValue().isEmpty()) {
	%>
			Any parameters configured
	<%
		}
	%>
	<ul>
	<% 	
		for (EventParameter param : entry.getValue()) {
	%>
			<li>
			<%= param.getEventParameterName()		 	%>
			: 
			<%= param.getEventParameterDescription() 	%>
			</li>
	<%
		}
	%>
	</ul>
		</td>
	</tr>
<%
	}
   }
%>
</tbody>
</table>
</section>
	
<%-- CREATE EVENT_TYPE --%>
<section id="createEventType">
<h1>EVENT_TYPE Creation</h1>
<%if(createEventTypeStatus != null) { %>
<p id="createEventTypeStatus"><%=createEventTypeStatus %></p>
<%}%>
<%if(errorEventTypeStatus != null) { %>
<p id="errorEventTypeStatus"><%=errorEventTypeStatus %></p>
<%}%>
	<table>
		<tr>
			<td><label>Event :</label></td>
			<td><input id="createEventTypeName" type="text" name="createEventTypeName" size="25" /></td>
		</tr>
		<tr>
			<td><label>Description : </label></td>
			<td><input id="createEventTypeDescription" type="text" name="createEventTypeDescription" size="50" /></td>
		</tr>
		<tr>
			<td>
				<input id="addEventType" type="submit" value="Add Event Type" /> 
			</td>
		</tr>
	</table>
</section>

<%-- CREATE EVENT_PARAMETER --%>
<section id="createEventParameter">
<h1>EVENT_PARAMETER Creation</h1>
<%if(createEventParameterStatus != null &&  ! createEventParameterStatus.equals("") ) { %>
<p id="createEventParameterStatus"><%=createEventParameterStatus %></p>
<%}%>
<%if(infoUnsetParameters != null) { %>
<p id="infoUnsetParameters"><%=infoUnsetParameters %></p>
<%}%>
	<table id="addEventParameter">
		<thead>
			<tr>
				<td><label>Event choice : </label></td>
				
				<%--On recupere tout les event type disponibles dans la table EVENT_TYPE suite au clic LoadEventType --%>
				<% if(eventTypesAvailable!=null && !eventTypesAvailable.isEmpty()) {%>
				<td>
				   <select id="eventChoice" name="eventChoice" size="1">
				    <% for(EventType eventType : eventTypesAvailable){ %>
				    <option><%=eventType.getEventTypeName()%></option>
				    <%} %>
				   </select>
				</td>
				<%} %>
		    </tr>
		</thead>
		<% if(eventTypesAvailable!=null && !eventTypesAvailable.isEmpty()) {%>
		<tbody>
			<tr>
				<th>Parameter Name</th>
				<th>Parameter Description</th>
				<th><input id="addParam" type="button" name="addParam" value="Add row" /></th>
			</tr>
			<tr>
				<td><input type="text" name="paramName" size="25" /></td>
				<td><input type="text" name="paramValue" size="25" /></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>
				  <input id="saveEventParameter" type="submit" name="submitButton" value="saveEventParameter" /> 
				</td>
			</tr>
		</tfoot>
		<%} %>
	</table>
<%if(eventTypesUnavailable != null) { %>
  <p id="eventTypesUnavailable"><%=eventTypesUnavailable %></p>
<%}%>
</section>
</div>
<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	
	/*
	 * Ajout dynamique d'une nouvelle ligne eventParameter
	 * @Author : tarik Djebien
	 */
	 var cpt = 1;
	 $("#addParam").click( function() {
	 		$('#addEventParameter > tbody:last')
				.append("<tr><td><input type='text' name='paramName' size='25' /></td><td><input type='text' name='paramValue' size='25' /></td><td><input type='button' id='deleteParam' class='crmButton' value='Delete row' /></td></tr>");
			$(".crmButton").button();
	 });
	 
	 /*
	  * Suppression dynamique d'une nouvelle ligne
	  * avec propagation des evenements
	  * @Author : tarik Djebien
	  */
	  $("#deleteParam").live('click', function() {
		 $($(this).parent().parent()).remove();
	  });
	  
});

/*
 * AJAX form call
 */
$("#addEventType").click( function() {
	$.ajax({
		type: 		'POST',
		url:  		"createEventType.event",
		data: 		{createEventTypeName: 			$("#createEventTypeName").val(),
					 createEventTypeDescription:	$("#createEventTypeDescription").val()}
	});
});
	
$("#saveEventParameter").click( function() {
	var paramNames = new Array();
	var paramValues = new Array();
		
	$('input[name="paramName"]').each(function() {
    	 paramNames.push( $(this).val() );    
 	});
 	$('input[name="paramValue"]').each(function() {
    	 paramValues.push( $(this).val() );    
 	});

	$.ajax({
		type: 		'POST',
		url:  		"saveEventParameter.event",
		data: 		{
					eventChoice: 			$("#eventChoice").val(),
					eventParameterName:		paramNames,
					eventParameterValue:   	paramValues
					}
	});
});

$("#createEventTypeStatus").addClass("ui-state-highlight");
$("#createEventParameterStatus").addClass("ui-state-highlight");
$("#errorEventTypeStatus").addClass("ui-state-error");
$("#eventTypesUnavailable").addClass("ui-state-error");
$("#infoUnsetParameters").addClass("ui-state-error");

$(document).ready(function() {
	$('.dataTables').dataTable( { "bJQueryUI": true } );
} );


</script>