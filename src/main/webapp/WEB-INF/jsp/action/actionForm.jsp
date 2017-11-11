<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Map" %>
<%@page import="com.miage.crm365.model.entity.EventParameter" %>
<%@page import="com.miage.crm365.model.entity.Action" %>
<%@page import="com.miage.crm365.model.entity.Team" %>

<%-- Variables --%>
<%
	List<EventParameter> eventParametersAvailable = (List<EventParameter>) request
			.getAttribute("eventParametersAvailable");
	List<Action> actions = (List<Action>) request
			.getAttribute("actions");
	String[] eventParameterClauses = (String[]) request
			.getAttribute("eventParameterClauses");
	List<Team> teams = (List<Team>) request.getAttribute("teams");
	List<String> customerColumns = (List<String>) request
			.getAttribute("customerColumns");
	Map<String, String> customerAlias = (Map<String, String>) request
			.getAttribute("customerAlias");
	Map<Long, List<String>> actionTriggerRules = (Map<Long, List<String>>) request
			.getAttribute("actionTriggerRules");
	Map<Long, List<String>> customerTriggerRules = (Map<Long, List<String>>) request
			.getAttribute("customerTriggerRules");

	// messages de retour venant du controller
	String infoUnsetParameters = (String) request
			.getAttribute("infoUnsetParameters");
	String infoUnsetParametersActionTrigger = (String) request
			.getAttribute("infoUnsetParametersActionTrigger");
	String createActionStatus = (String) request
			.getAttribute("createActionStatus");
	String createEventParameterTriggerStatus = (String) request
			.getAttribute("createEventParameterTriggerStatus");
	String infoEventParametersNotExisting = (String) request
			.getAttribute("infoEventParametersNotExisting");
	String infoActionsNotExisting = (String) request
			.getAttribute("infoActionsNotExisting");
	String infoEventParameterClausesNotExisting = (String) request
			.getAttribute("infoEventParameterClausesNotExisting");
	Boolean infoCustomerTrigger = (Boolean) request
			.getAttribute("infoCustomerTrigger");
%>
<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#actionConfiguration">Action configuration</a></li>
		<li><a href="#actionCreation">Action Creation</a></li>
		<li><a href="#actionTriggerCreation">Action Trigger Creation</a></li>
		<li><a href="#customerTriggerCreation">Customer Trigger Creation</a></li>
		
	</ul>

<section id="actionConfiguration">
	
	<h1><spring:message code="actionConfigurationTitle" /></h1>
	
	<table class="dataTables">
		<thead>
			<tr>
				<th>action description</th>
				<th>action trigger configuré</th>
				<th>customer trigger configuré</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (Action action : actions) {
		%>
			<tr>
				<td><%=action.getActionDescription()%></td>
				<td>	
					<ul>
						<%
							List<String> rulesForActionId = actionTriggerRules.get(action
										.getActionId());
								for (String rule : rulesForActionId) {
						%>
						<li><%=rule%></li>
						<%
							}
						%>
					</ul>
				</td>
				<td>	
					<ul>
						<%
							List<String> customerRulesForActionId = customerTriggerRules.get(action
										.getActionId());
								for (String rule : customerRulesForActionId) {
						%>
						<li><%=rule%></li>
						<%
							}
						%>
					</ul>
				</td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
</section>

<section id="actionCreation">
<h1><spring:message code="actionCreationTitle"/></h1>
<%
	if (createActionStatus != null) {
%>
<p id="createActionStatus"><%=createActionStatus%></p>
<%
	}
%>
<%
	if (infoUnsetParameters != null) {
%>
	<p id="infoUnsetParameters"><%=infoUnsetParameters%></p>
<%
	}
%>

<table>
	<tr>
		<td><label>Description :</label></td>
		<td><input id="createActionDescription" type="text" name="createActionDescription" size="25" /></td>
	</tr>
	<tr>	
		<td><label>Team to affect :</label></td>
		<%--On recupere tout les event parameter presents en base LoadEventParameter --%>
		<%
			if (teams != null && !teams.isEmpty()) {
		%>
		<td>
		   <select id="teamChoice" name="teamChoice" size="1">
		    <%
		    	for (Team team : teams) {
		    %>
		   	    <option value="<%=team.getTeamId()%>"><%=team.getTeamDescription()%></option>   
		    <%
   		    	}
   		    %>
		  </select> 
		<%
 			}
 		%>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input id="submitAddAction" type="submit" value="Add Action" />
		</td>
	</tr>
</table>
</section>

<section id="actionTriggerCreation">
<h1><spring:message code="actionTriggerCreationTitle"/></h1>
<%
	if (createEventParameterTriggerStatus != null) {
%>
<p id="createEventParameterTriggerStatus"><%=createEventParameterTriggerStatus%></p>
<%
	}
%>
<%
	if (infoUnsetParametersActionTrigger != null) {
%>
	<p id="infoUnsetParametersActionTrigger"><%=infoUnsetParametersActionTrigger%></p>
<%
	}
%>

<table>
		<tr>
			<td><label>Event Parameter select :</label></td>
				<%--On recupere tout les event parameter presents en base LoadEventParameter --%>
				<%
					if (eventParametersAvailable != null
							&& !eventParametersAvailable.isEmpty()) {
				%>
				<td>
				   <select id="eventParameterChoice" name="eventParameterChoice" size="1">
				    <%
				    	for (EventParameter eventParameter : eventParametersAvailable) {
				    %>
				    	    <option><%=eventParameter.getEventParameterName()%></option>    	   
				    <%
    	   				    	}
    	   				    %>
				  </select> 
			    </td>
			    <%
			    	}
			    %>
		</tr>
			
				<%
								if (infoEventParametersNotExisting != null) {
							%>
					<tr>
  						<td><p><%=infoEventParametersNotExisting%></p></td>
  					</tr>
				<%
					}
				%>
		
		
		<tr>
			<td><label>Action select :</label></td>
				<%--On recupere tout les event parameter presents en base LoadEventParameter --%>
				<%
					if (actions != null && !actions.isEmpty()) {
				%>
				<td>
				   <select id="actionChoice" name="actionChoice" size="1">
				    <%
				    	for (Action action : actions) {
				    %>
				    	    <option><%=action.getActionDescription()%></option>
				    <%
				    	}
				    %>
				  </select> 
			    </td>
			    <%
			    	}
			    %>
		</tr>
				<%
					if (infoActionsNotExisting != null) {
				%>
				<tr>
	  				<td><p><%=infoActionsNotExisting%></p></td>
	  			</tr>
				<%
					}
				%>
		
		<tr>
		<td><label>EventParameterClause select :</label></td>
				<%--On recupere tout les event parameter presents en base LoadEventParameter --%>
				<%
					if (eventParameterClauses != null) {
				%>
				<td>
				   <select id="eventParameterClauseChoice" name="eventParameterClauseChoice" size="1">
				    <%
				    	for (String eventParameterClause : eventParameterClauses) {
				    %>
				    	    <option><%=eventParameterClause%></option>
				    <%
				    	}
				    %>
				  </select> 
			    </td>
			    <%
			    	}
			    %>
		</tr>
				<%
					if (infoEventParameterClausesNotExisting != null) {
				%>
				<tr>
	  				<td><p><%=infoEventParameterClausesNotExisting%></p></td>
	  			</tr>
				<%
					}
				%>
		<tr>
			<td><label>eventParameterTrigger :</label></td>
			<td><input id="createEventParameterTrigger" type="text" name="createEventParameterTrigger" size="25" /></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input id="submitAddEventParameterTrigger" type="submit" value="AddEventParameterTrigger" />
			</td>
		</tr>
	</table>
</section>

<section id="customerTriggerCreation">

<%
	if (infoCustomerTrigger != null) {
%>
	<%
		if (infoCustomerTrigger) {
	%>
		<p id="customerTriggerSaved" class="infoNotification">
			Customer trigger added
		</p>
	<%
		}
	%>
	<%
		if (!infoCustomerTrigger) {
	%>
		<p id="customerTriggerNotSaved" class="errorNotification">
			Please feed required fields
		</p>
	<%
		}
	%>
<%
	}
%>

<table>
	<tr>
		<td>Action selection</td>
		<td>
			<select id="customerTriggerAction" size="1">
			<%
				for (Action action : actions) {
			%>
				<option value="<%=action.getActionId()%>"><%=action.getActionDescription()%></option>
			<%
				}
			%>
			</select>
		</td>
	</tr>
	<tr>
		<td>Field selection</td>
		<td>
			<select id="customerTriggerField" size="1">
			<%
				for (String field : customerColumns) {
			%>
		   	    <option value="<%=customerAlias.get(field) == null ? field
						: customerAlias.get(field)%>"><%=field%></option>   
		    <%
   		    	}
   		    %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Clause</td>
		<td>
			<select id="customerTriggerClause" size="1">
			<%
				for (String eventParameterClause : eventParameterClauses) {
			%>
				<option value="<%=eventParameterClause%>"><%=eventParameterClause%></option>
			<%
				}
			%>
			</select>
		</td>
	</tr>
	<tr>
		<td>Trigger on</td>
		<td>
			<input id="customerTriggerTrigger" type="text" size="25" />
		</td>
	</tr>
	<tr>
		<td></td>	
		<td>
			<input id="submitAddCustomerTrigger" type="submit" value="Add" />
		</td>
	</tr>
</table>
</section>

</div>
<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
	
	$("#submitAddAction").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"createAction.action",
			data: 		{
						createActionDescription: 	 $("#createActionDescription").val(),
						teamChoice:				 	 $("#teamChoice").val()
						}
		});
	});
	
	
	$("#submitAddEventParameterTrigger").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"createActionTrigger.action",
			data: 		{
						eventParameterChoice: 			$("#eventParameterChoice").val(),
						eventParameterClauseChoice:		$("#eventParameterClauseChoice").val(),
						actionChoice:					$("#actionChoice").val(),
						createEventParameterTrigger:	$("#createEventParameterTrigger").val()
						}
		});
	});
	
	$("#submitAddCustomerTrigger").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"createCustomerTrigger.action",
			data: 		{
						customerTriggerAction: 			$("#customerTriggerAction").val(),
						customerTriggerField:			$("#customerTriggerField").val(),
						customerTriggerClause:			$("#customerTriggerClause").val(),
						customerTriggerTrigger:			$("#customerTriggerTrigger").val()
						}
		});
	});
	
	$("#createActionStatus").addClass("ui-state-highlight");
	$("#infoUnsetParameters").addClass("ui-state-error");
	$("#createEventParameterTriggerStatus").addClass("ui-state-highlight");
	$("#infoUnsetParametersActionTrigger").addClass("ui-state-error");
	$("#infoEventParametersNotExisting").addClass("ui-state-error");
	$("#infoActionsNotExisting").addClass("ui-state-error");
	$("#infoEventParameterClausesNotExisting").addClass("ui-state-error");
	$('.dataTables').dataTable({
		"bJQueryUI" : true
	});
</script>