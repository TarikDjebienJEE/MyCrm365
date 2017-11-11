<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page import="com.miage.crm365.model.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.crm365.model.entity.CustomerAlias" %>
<%-- Variables --%>
<%	
	Customer customer = (Customer) request.getAttribute("customer");
	List<CustomerAlias> allCustomerAlias = (List<CustomerAlias>) request.getAttribute("allCustomerAlias");
	Map<String , String > freeValMapValue = (Map<String , String >) request.getAttribute("freeValMapValue");
%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#customerDetail">Customer detail </a></li>
	</ul>
<section id="customerDetail">

	<table>
		<tr>
			<td><spring:message code="customer.id" /></td>
			<td><%= customer.getCustomerId() 			%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.companyId" /></td>
			<td><%= customer.getCustomerCompagnyId() 	%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.surname" /></td>
			<td><%= customer.getFirstName()				%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.name" /></td>
			<td><%= customer.getLastName()				%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.homephone" /></td>
			<td><%= customer.getHomePhone()				%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.mobilephone" /></td>
			<td><%= customer.getMobilePhone()			%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.workphone" /></td>
			<td><%= customer.getWorkPhone()				%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.subdate" /></td>
			<td><%= customer.getSubscriptionDate()		%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.email" /></td>
			<td><%= customer.getMail()					%></td>
		</tr>
		<tr>	
			<td><spring:message code="customer.address" /></td>
			<td><%= customer.getAddress()				%></td>
		</tr>
		
		<%for (CustomerAlias customerAlias : allCustomerAlias) {%>
			<tr>
				<td><%= customerAlias.getFreeValAlias()%></td>
				<td>
					<input name="freeValName"   type="hidden"  value='<%= customerAlias.getFreeValName()%>'  />
					<%
						String freeValue = freeValMapValue.get(customerAlias.getFreeValName());
					%>
					<input name="freeValValue"  type="text"    value='<%= freeValue == "null" || freeValue == null ? "" : freeValue   %>'  />
				</td>
			</tr>
		<%}%>
		
		<tr>
			<td>
				<input id='saveCustomer' type='button' name='saveCustomer' value='<spring:message code="saveAll" />'/>
			</td>
		</tr>
	</table>

</section>
</div>
<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	
	/*
	 * Permet la mise a jour du client, notamment de ces freeValX
	 */	
	 $("#saveCustomer").click( function() {
			var freeValName = new Array();
		    var freeValValue = new Array();
			$('input[name="freeValName"]').each(function() {
				freeValName.push( $(this).val() );   
		 	});
			$('input[name="freeValValue"]').each(function() {
				freeValValue.push( $(this).val() );   
		 	});
			$.ajax({
				type: 		'POST',
				url:  		"updateFreeValCustomerRow.customer",
				data: 		{
								idCustomer: 			<%= customer.getCustomerId()%>,
								freeValValue:			freeValValue,
								freeValName :			freeValName,
							}
			});
		});

});
</script>