<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%-- Variables --%>
<%
	List<String> files = (List<String>) request.getAttribute("files");
%>


<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a href="#customerSearch"><spring:message code="event.automatedImportEventFromCsv" /></a></li>
		<li><a id= "menu_download_template" href="#eventAllFileTemplateDownload"><spring:message code="event.eventAllDownloadTemplateFile" /></a></li>
	</ul>
	
	<section id="customerSearch">
		<!--Formulaire permettant d'uploader un fichier-->
		<form method="post" action="uploadEventsFromCsv.event" enctype="multipart/form-data">
				<label for="input_file_field"><spring:message code="csv-file" /></label>
				<div class="field">
					<input id="inputForFileUpload" class="text" name="file" size="53" type="file">
				</div>
				<input value="Ok" type="submit">
				<input value="<spring:message code="annuler"/>" type="reset" class="crmButton">
		</form>
	</section>
	
	
		
	<!--Partie permettant le telechargemetn d'un fichier de template-->
	<section id="eventAllFileTemplateDownload">
		<table class="dataTables">
			<thead>
				<tr>
					<th>Filename</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<%for (String file : files) {%>
					<tr>
						<td><%=file%>.csv</td>
						<td><a href="downloadTemplateEvent.event?userTypeName=<%= file %>" >Download template</a></td>
					</tr>
				<%}%>
			</tbody>
		</table>
	</section>
</div>