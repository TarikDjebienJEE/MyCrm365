<%@page import="com.miage.crm365.utils.CRM365Constants"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@page import="com.miage.crm365.utils.DateUtil"%>
<%@page import="java.util.List" %>
<%@page import="com.miage.crm365.model.entity.Customer" %>
<%@page import="com.miage.crm365.model.entity.EventType" %>
<%@page import="com.miage.crm365.model.entity.EventParameter" %>

<%-- Variables --%>
<%
// liste des clients existant en base
List<Customer> customers = (List<Customer>) request.getAttribute("customers");
// liste des event type existant en base
List<EventType> eventTypes = (List<EventType>) request.getAttribute("eventTypes");
//liste des eventParameter existant en base et correspondant à l'eventType choisi
List<EventParameter> eventParameters = (List<EventParameter>) request.getAttribute("eventParameters");
String customerSelected = (String) request.getAttribute("customerSelected");
String eventTypeSelected = (String) request.getAttribute("eventTypeSelected");

// messages de retour
String infoCustomersNotExisting = (String) request.getAttribute("infoCustomersNotExisting");
String infoEventTypeNotExisting = (String) request.getAttribute("infoEventTypeNotExisting");
String infoEventParametersNotExisting = (String) request.getAttribute("infoEventParametersNotExisting");
String infoUnsetParameters = (String) request.getAttribute("infoUnsetParameters");

String createEventStatus = (String) request.getAttribute("createEventStatus");
%>

<%-- @author : rudy stienne --%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#createEventByManualAction">EVENT_MANUAL Creation</a></li>
	</ul>
<%-- CREATE EVENT BY MANUAL ACTION--%>
<section id="createEventByManualAction">
<h1>EVENT_MANUAL Creation</h1>
<%if(createEventStatus != null) { %>
<p id="createEventTypeStatus"><%=createEventStatus %></p>
<%}%>
	<table>
		<tr>
			<td><label>Date :</label></td>
			<td><input id="createEventManualDate" type="text" name="createEventManualDate" size="15" value="<%=DateUtil.todayToString(CRM365Constants.DATE_FORMAT_FR)%>" /></td>
		</tr>
		<tr>
				<td><label>Customer select : </label></td>
				<%--On recupere tout les clients presents en base LoadCustomers --%>
				<% if(customers!=null && !customers.isEmpty()) { %>
				<td>
				   <select id="customerChoice" name="customerChoice" size="1">
				    <% 
				    Customer customerSeleted=null;
				      if (customerSelected != null) {
				    	
				    %>
				    	<!-- recuperer le customer par rapport à son id renvoyé -->
				    	<%  for(Customer customer : customers) { 
				    		if(customer.getCustomerId()==Long.parseLong(customerSelected)){
				    			customerSeleted=customer;
				    			}  
				    		}%>
				    		
				    	<option value="<%=customerSeleted.getCustomerId()%>"><%=customerSeleted.getLastName() + " " + customerSeleted.getFirstName()%></option>
				    			
				    <%
				      }
				      for(Customer customer : customers) { 
				    %>
				    <% String customerCurrent = customer.getLastName() + " " + customer.getFirstName(); %>
				  		<%if (customerSeleted!=customer) {%>
				    	    <option value="<%=customer.getCustomerId()%>"><%=customerCurrent%></option>
				    	 <%} %>
				    	   
				   <% }  %>
				  </select>
				
				  
			    </td>
		</tr>
				<% } %>
		
				<% if(infoCustomersNotExisting != null) { %>
  					<p id="infoCustomersNotExisting"><%=infoCustomersNotExisting %></p>
				<% } %>
			
		<tr>
			<td><label>Event type select : </label></td>
			
			
			<%--On recupere tout les eventType presents en base LoadEventTypes --%>
			<% if(eventTypes!=null && !eventTypes.isEmpty()) {%>
			<td>
				<select id="eventTypeChoice" name="eventTypeChoice"  size="1">
				<%
					if (eventTypeSelected != null) {
				%>
						<option><%=eventTypeSelected %></option>
				<%
					}
				%>
				 <% for(EventType eventType : eventTypes){ %>
							<option><%=eventType.getEventTypeName() %></option>
				 <% } %>
				</select>
			</td>
			<td>
				<i>Choose your event to feed parameters</i>
			</td>
		</tr>
	
			<% } %>
		
			<%if(infoEventTypeNotExisting != null) { %>
  				<p id="infoEventTypeNotExisting"><%=infoEventTypeNotExisting %></p>
			<% } %>
			
			<%--On recupere tout les eventParameter en base correspondant à l'eventType choisi --%>
			<% if(eventParameters!=null && !eventParameters.isEmpty()) {%>	
		<tr>
				<td><label>Event Parameters</label></td>
				<td><label>Event Parameters Value</label></td>
		</tr>
				
			<table id="event_param" >
		    <% int i=0;
			  for(EventParameter eventParameter : eventParameters) { %>
				 <tr>
						<input id="eventParameterName" name="paramName"		type="hidden" value=<%=eventParameter.getEventParameterName() + i%>/>
						<td><label><%=eventParameter.getEventParameterName()%></label></td>
						<td><input id="eventParameterValue" name="paramValue" type="text" size="40" /></td>
				</tr>
				 <%i++;
			  } %>
			</table>
			<input id="createEventManual" name="createEventManual" type="submit" value="Save event"/> 
		   <% } 
		  
			
			if(infoEventParametersNotExisting != null) { %>
  				<p id="infoEventParametersNotExisting"><%=infoEventParametersNotExisting %></p>
			<% } %>
	</table>
</section>
</div>
<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">	
	$("#createEventManualDate").datepicker();
	
    /*
     * AJAX calls
     */
    $("#eventTypeChoice").change( function() {
		$.ajax({
			type: 		'POST',
			url:  		"loadEventParameters.manualEvent",
			data: 		{
						eventTypeChoice: 		$("#eventTypeChoice").val(),
						customerChoice:			$("#customerChoice").val()
						}
		});
	});
	
	$("#createEventManual").click( function() {
		var paramNames = new Array();
		var paramValues = new Array();
		var customerSelected = $("#customerChoice").val();
		
		
		$('input[name="paramName"]').each(function() {
    		 paramNames.push( $(this).val() );    
 		});
 		$('input[name="paramValue"]').each(function() {
    		 paramValues.push( $(this).val() );    
 		});
	
		$.ajax({
			type: 		'POST',
			url:  		"createEventManual.manualEvent",
			data: 		{
						 eventTypeChoice: 		$("#eventTypeChoice").val(),
						 customerId: customerSelected,
						 eventParameterName:	paramNames,
						 eventParameterValue:   paramValues
						}
		});
	});
	
	$("#createEventTypeStatus").addClass("ui-state-highlight");
    $("#infoCustomersNotExisting").addClass("ui-state-error");
    $("#infoEventTypeNotExisting").addClass("ui-state-error");
    $("#infoEventParametersNotExisting").addClass("ui-state-error");
    
</script>