<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.io.File" %>


<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#customerSearch"><spring:message code="customer-file-input" /></a></li>
		<li><a id= "menu_download" href="#customerFileTemplateDownload"><spring:message code="customer.customerDownloadTemplateFile" /></a></li>
	</ul>
	
	<!--Formulaire permettant d'uploader un fichier-->
	<section id="customerSearch">
		<form method="post" action="uploadCustomerFromCsv.customer" enctype="multipart/form-data">
				<label for="input_file_field"><spring:message code="csv-file" /></label>
				<div class="field">
					<input id="inputForFileUpload" class="text" name="file" size="53" type="file">
				</div>
				<input value="Ok" type="submit">
				<input value="<spring:message code="annuler"/>" type="reset" class="crmButton">
		</form>
	</section>
	
	
	<!--Partie permettant le telechargement d'un fichier de template-->
	<section id="customerFileTemplateDownload">
		<table>
			<tr>
				<td>Customer.csv</td>
				<td><a id="downloadTemplateButton" href="downloadCustomerTemplate.customer?customerFile=customerFile">Download template</a> 
			</tr>
		</table>
	</section>
</div>