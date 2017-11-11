<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.crm365.model.entity.CustomerAlias" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%-- Variables --%>
<%
	List<CustomerAlias> allCustomerAlias = (List<CustomerAlias>) request.getAttribute("allCustomerAlias");
	Integer sizeAllCustomerAlias = (Integer) request.getAttribute("sizeAllCustomerAlias");
%>
<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#manageUser"><spring:message code="customerAlias.customizationManagement" /></a></li>
	</ul>
<%-- MANAGE USER --%>
<section id="manageUser">
		<table id="tableCustomerAlias" class="dataTables">
			<thead>
				<tr>
					<th>Id</th>
					<th>FreeValName</th>
					<th>FreeValAlias</th>
					<th>Modify</th>
				</tr>
			</thead>
		<% if(allCustomerAlias!=null && !allCustomerAlias.isEmpty()) {%>	
			<tbody>
				<%for (CustomerAlias customerAlias : allCustomerAlias) {%>
					<tr>
						<td>
							<input id="idCustomerAlias" name="nameIdCustomerAlias" type="text" value="<%=customerAlias.getIdCustomerAlias()%>" size="2" disabled/>
							<span style="visibility: hidden; display: none;"><%=customerAlias.getIdCustomerAlias()%></span>
						</td>
						
						<td>
							<input id="freeValName<%="_" + customerAlias.getIdCustomerAlias()%>"  name="nameFreeValName" type="text" value="<%=customerAlias.getFreeValName()%>" size="15" disabled/>
							<span style="visibility: hidden; display: none;"><%=customerAlias.getFreeValName()%></span>
						</td>
						
						<td>
							<input id="freeValAlias<%="_" + customerAlias.getIdCustomerAlias()%>" name="namefreeValAlias" type="text" value="<%=customerAlias.getFreeValAlias()%>" size="40"/>
							<span style="visibility: hidden; display: none;"><%=customerAlias.getFreeValAlias()%></span>
						</td>
						
						<td><input id="modify<%="_" + customerAlias.getIdCustomerAlias()%>" type="submit" value="Modify" /></td>
					</tr>
				<%}%>
			</tbody>
			<%}%>
					
		</table>
		<input id='saveAll' type='button' name='saveAll' value='<spring:message code="saveAll" />' disabled/>
		<input id="addNewRow" type="button" name="addNewRow" value='<spring:message code="addRow" />' />
		<input id="sizeAllCustomerAlias" type="hidden" value="<%=sizeAllCustomerAlias%>" />
		
		<input id="addRowMessage"     type="hidden"    value='<spring:message code="addRow" />'  />
		<input id="deleteRowMessage"  type="hidden"    value='<spring:message code="deleteRow" />'  />

</section>

</div>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">
$(document).ready(function(){
	
	var cpt = $("#sizeAllCustomerAlias").val()  ; 
	var addRowMessage = $("#addRowMessage").val()  ; 
	var deleteRowMessage = $("#deleteRowMessage").val()  ; 
	/*
	 * Ajout dynamique d'une nouvelle ligne customerAlias
	 */
	 $("#addNewRow").click( function() {
			cpt ++ ;
			if (cpt == 1){
		 		$('#tableCustomerAlias')
				.append("<thead><tr><th>Id</th><th>FreeValName</th><th>FreeValAlias</th></tr></thead><tbody><tr><td><input type='text' name='nameIdCustomerAlias' size='2' value="+cpt+" disabled/></td><td><input type='text' name='nameFreeValName' size='15' value=freeVal"+cpt+" disabled/></td><td><input type='text' name='namefreeValAlias' size='70' /></td><td><input type='button' id='deleteRow' class='crmButton' value='"+deleteRowMessage+"'/></td></tr></tbody>");
			}else{
		 		$('#tableCustomerAlias > tbody:last')
					.append("<tr><td><input type='text' name='nameIdCustomerAlias' size='2' value="+cpt+" disabled/></td><td><input type='text' name='nameFreeValName' size='15' value=freeVal"+cpt+" disabled/></td><td><input type='text' name='namefreeValAlias' size='70' /></td><td><input type='button' id='deleteRow' class='crmButton'  value='"+deleteRowMessage+"'/></td></tr>");
				$(".crmButton").button();
			}
			$(".crmButton" ).button('option', 'disabled', false);
	 });
	 
	
	
	/*
	 * Permet la modification de la ligne dont le bouton a ete appuye
	 */	
	$("[id ^=modify_]").click(function() {
		$(".crmButton" ).button('option', 'disabled', false);
		var id = $(this).attr("id");
		var idCustomerAlias = id.substring("modify_".length);
		$.ajax({
			type : 'POST',
			url : "updateCustomerAlias.customer",
			data : {
				idCustomerAlias : idCustomerAlias,
				freeValName : $("#freeValName_" + idCustomerAlias).val(),
				freeValAlias : $("#freeValAlias_" + idCustomerAlias).val(),
			}
		});
	});
	
			
	
	/*
	 * Permet la sauvegarde de toutes les nouvelles lignes 
	 */	
	 $("#saveAll").click( function() {
		    var idCustomerAlias = new Array();
			var freeValName = new Array();
			var freeValAlias = new Array();
				
			$('input[name="nameIdCustomerAlias"]').each(function() {
				idCustomerAlias.push( $(this).val() );   
		 	});
			$('input[name="nameFreeValName"]').each(function() {
				freeValName.push( $(this).val() );    
		 	});
		 	$('input[name="namefreeValAlias"]').each(function() {
		 		freeValAlias.push( $(this).val() );    
		 	});
			$.ajax({
				type: 		'POST',
				url:  		"saveCustomerAlias.customer",
				data: 		{
							idCustomerAlias: 		idCustomerAlias,
							freeValName:			freeValName,
							freeValAlias:   		freeValAlias
							}
			});
		});

	
	 /*
	  * Suppression dynamique d'une nouvelle ligne
	  * avec propagation des evenements
	  * @Author : tarik Djebien
	  */
	  $("#deleteRow").live('click', function() {
		 $($(this).parent().parent()).remove();
	  });
	  
	  $('.dataTables').dataTable( {"bJQueryUI": true} );
});
</script>
