<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page import="java.util.List" %>
<%@page import="com.miage.crm365.model.entity.Customer" %>

<%-- Variables --%>
<%	
	List<Customer> customers = (List<Customer>) request.getAttribute("customers");
	Boolean noResult = (Boolean) request.getAttribute("noResult");
%>
<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#customerSearch"><spring:message code="customer-search" /></a></li>
	</ul>
<section id="customerSearch">

	<%
	if ( noResult != null && noResult ) { 
	%>
		<p id="notification"><spring:message code="customer.search.noResult" /></p>
	<%
	}
	%>	

	<table>
		<tr>
			<th><spring:message code="customer.companyId" /></th>
			<th><spring:message code="customer.surname" /> 	</th>
			<th><spring:message code="customer.name" />	</th>
		</tr>
		
		<%
		if (customers != null) {
			for (Customer customer : customers) {
		%>
		<tr>
			<td>
				<a href="#" name="customerDetail" ><%= customer.getCustomerCompagnyId() 	%></a>
				<input  type="hidden" value="<%= customer.getCustomerId() %>" />
			</td>
			<td><%= customer.getFirstName()				%></td>
			<td><%= customer.getLastName() 				%></td>
		</tr>
		<%
			}
		}
		%>
		
	</table>

</section>
</div>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">

	$("a[name='customerDetail']").click( function() {
		$.ajax({
			type: 		'POST',
			url:  		"customerDetail.customer",
			data: 		{
						customerId: 			$(this).next().val()	
						}
			  });
	});
	
	$("#notification").addClass("ui-state-highlight");

</script>