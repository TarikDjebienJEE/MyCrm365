<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.crm365.model.entity.Team" %>
<%@ page import="com.miage.crm365.model.entity.UserTeam" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!-- variables -->
<%
List<Team> teams = (List<Team>) request.getAttribute("teams");
List<UserTeam> usersTeam = (List<UserTeam>) request.getAttribute("usersTeam");
List<UserTeam> usersTeamExisting= (List<UserTeam>) request.getAttribute("usersTeamExisting");
List<String> usersNameNotInTeam = (List<String>) request.getAttribute("usersNameNotInTeam");
Team teamUser = (Team) request.getAttribute("teamUser");
List<Integer> numbersOfMember = (List<Integer>) request.getAttribute("numbersOfMember");

Boolean administrationServiceSaveTeam = (Boolean) request.getAttribute("administrationServiceSaveTeam");
Boolean administrationServiceDeleteTeam = (Boolean) request.getAttribute("administrationServiceDeleteTeam");
Boolean administrationServiceUpdateTeam = (Boolean) request.getAttribute("administrationServiceUpdateTeam");
Boolean administrationServiceAddUserInTeam = (Boolean) request.getAttribute("administrationServiceAddUserInTeam");
Boolean administrationServiceDeletedUserInTeam = (Boolean) request.getAttribute("administrationServiceDeletedUserInTeam");
%>

<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a id="tabCreateTeam" href="#createTeam"><spring:message code="admin.Tab.TeamCreation" /></a></li>
		<li><a id="tabManageTeam" href="#manageTeam"><spring:message code="admin.Tab.TeamManagement"/></a></li>
	</ul>

<%-- CREATE TEAM --%>
<section id="createTeam">
	<h1><spring:message code="admin.createTeam.title" /></h1>
	<% if(administrationServiceSaveTeam != null && administrationServiceSaveTeam) { %>
		<p id="createTeamStatus" class="ui-state-highlight"><spring:message code="admin.administrationServiceSaveTeam" /></p>
	<% } %>
	<table>
		<% if(teams!= null && !teams.isEmpty()) { %>
		<tr>
			<td>
					<label id="team"><spring:message code="admin.createTeam.titleTeams" /></label>
				<ul>
					<%for(Team team : teams){ %>
						<li><%=team.getTeamDescription()%></li>
					<%}%>
				</ul>
			</td>
		</tr>
		<%}%>
		<tr>
			<td><label><spring:message code="admin.createTeam.description" /></label></td>
			<td><input id="createTeamDescription" type="text" name="createTeamDescription" size="25" /></td>
		</tr>
		<tr>
			<td>
				<input id="submitCreateTeam" type="submit" value="Create new Team" /> 
			</td>
		</tr>
	</table>
</section>

<%-- MANAGE TEAM --%>
<section id="manageTeam">
	<h1><spring:message code="admin.manageTeam.title" /></h1>
	<% if(administrationServiceDeleteTeam != null && administrationServiceDeleteTeam) { %>
		<p id="deleteTeamStatus" class="ui-state-highlight"><spring:message code="admin.administrationServiceDeleteTeam" /></p>
	<% } %>
	<% if(administrationServiceUpdateTeam != null && administrationServiceUpdateTeam) { %>
		<p id="saveTeamStatus" class="ui-state-highlight"><spring:message code="admin.administrationServiceUpdateTeam" /></p>
	<% } %>
	<% if(administrationServiceAddUserInTeam != null && administrationServiceAddUserInTeam) { %>
		<p id="addUserTeamStatus" class="ui-state-highlight"><spring:message code="admin.administrationServiceAddUserInTeam" /></p>
	<% } %>
	<% if(administrationServiceDeletedUserInTeam != null && administrationServiceDeletedUserInTeam) { %>
		<p id="deleteUserTeamStatus" class="ui-state-highlight"><spring:message code="admin.administrationServiceDeletedUserInTeam" /></p>
	<% } %>
	
	<!--   j'ai enlevé class="dataTables" de l'element table ci dessous -->
	<!--   car lors du premier clic sur bouton submitAddTeamUser on a un message d'alert du au dataTables "DataTables warning ....  " -->
	<table>
		<thead>
			<tr>
				<th><spring:message code="admin.manageTeam.teamId" /></th>
				<th><spring:message code="admin.manageTeam.teamDescription" /></th>
				<th><spring:message code="admin.manageTeam.users" /></th>
				<th><spring:message code="admin.manageTeam.numberOfMembers" /></th>
				<th><spring:message code="admin.manageTeam.delete" /></th>
				<th><spring:message code="admin.manageTeam.save" /></th>
				<th><spring:message code="admin.manageTeam.addUser" /></th>
				<th><spring:message code="admin.manageTeam.deleteUser" /></th>
			</tr>
		</thead>
		<tbody>
			<% if(teams!= null && !teams.isEmpty()) { %>
						<%
							int i=0;
							for(Team team : teams){
						%>
				<tr>
					<td>
						<input id="teamId" type="text" readonly="readonly" disabled="disabled" value="<%=team.getTeamId()%> " size="10"/>
						<span style="visibility: hidden; display: none;"><%=team.getTeamId()%></span>
					</td>
					<td>
						<input id="teamDescription<%="_" + team.getTeamId()%>" type="text" value="<%=team.getTeamDescription()%>" size="10"/>
						<span style="visibility: hidden; display: none;"><%=team.getTeamDescription()%></span>
					</td>
					<td>
						<select id="userNameChoice" name="userNameChoice">
						<%
							if(usersTeam != null && !usersTeam.isEmpty()) {
							for (UserTeam userTeam : usersTeam) {
								Long idUserTeam = userTeam.getTeamId();
								Long idTeam = team.getTeamId();
								
								if(idUserTeam.equals(idTeam)){
									
						%>
							<option><%=userTeam.getUsername()%></option>
						<%
								}
							}
							}
						%>
						</select>
					</td>
					<td>
				 	<input id="numberOfMember" type="text" readonly="readonly" disabled="disabled" value="<%=numbersOfMember.get(i++)%>" size="10"/> 
				 	<span style="visibility: hidden; display: none;"><%=numbersOfMember.get(i-1)%></span>
					</td>
					<td>
						<input id="submitDeleteTeam<%="_" + team.getTeamId()%>" type="submit" value="Delete Team" />
					</td>
					<td>
						<input id="submitSaveTeam<%="_" + team.getTeamId()%>" type="submit" value="Save Team" />
					</td>
					<td>
						<input id="submitAddTeamUser<%="_" + team.getTeamId()%>" type="submit" value="Add User" />
					</td>
					<td>
						<input id="submitDeleteTeamUser<%="_" + team.getTeamId()%>" type="submit" value="Delete User" />
					</td>
				</tr>
				
			
						<%}%> <!-- fin de la boucle team -->
						
				<%
				if(usersNameNotInTeam!= null && !usersNameNotInTeam.isEmpty()) {%>
				<tr>
					<td>
					<select id="usernameChoice" name="usernameChoice" size="1">
					<% for(String username : usersNameNotInTeam){%>
						<option value="<%=username%>"><%=username%></option>
						<% } %>
					</select>
					</td>
					<td>
						<% if(teamUser!= null ) {%>
							<label>Add user in Team : </label> <%=teamUser.getTeamId()%>
						<% } %>
					</td>
					<td>
						<input id="submitAddUserInTeam<%="_" + teamUser.getTeamId()%>" type="submit" value="Add User In Team" />
					</td>
				</tr>
				<%} %>
				
				<% if(usersTeamExisting!= null && !usersTeamExisting.isEmpty() ) {%>
				<tr>
					<td>
					<select id="usernameChoiceForDelete" name="usernameChoiceForDelete" size="1">
						<%
							if(usersTeam!=null && !usersTeam.isEmpty()) {
							for (UserTeam userTeam : usersTeam) {
								if(userTeam.getTeamId().equals(teamUser.getTeamId())){		
						%>
						 	<option value="<%=userTeam.getUsername()%>"><%=userTeam.getUsername()%></option>
						<%
								}
							}
							}
						%>
						</select>
					</td>
					<td>
						<% if(teamUser!= null ) {%>
							<label>Delete user of the Team : </label> <%=teamUser.getTeamId()%>
						<% } %>
					</td>
					<td>
						<input id="submitDeleteUserInTeam<%="_" + teamUser.getTeamId()%>" type="submit" value="Delete User of the Team" />
					</td>
				</tr>
				<%} %>
					
		<%}%>
		
		</tbody>
	</table>
</section>


</div>



<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">

	$("#submitCreateTeam").click(
		function() {
			$.ajax({
				type : 'POST',
				url : "createTeam.admin",
				data : {
					createTeamDescription : $("#createTeamDescription").val()
				}
			});
		});
	
	$("[id ^=submitDeleteTeam_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitDeleteTeam_".length);
		$.ajax({
			type : 'POST',
			url : "deleteTeam.admin",
			data : {
				teamId : teamId
			}
		});
	});
	
	$("[id ^=submitSaveTeam_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitSaveTeam_".length);
		var description = $("#teamDescription_" + teamId).val();
		
		
		$.ajax({
			type : 'POST',
			url : "saveTeam.admin",
			data : {
				teamId : teamId,
				description : description
			}
		});
	});
	
	$("[id ^=submitAddTeamUser_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitAddTeamUser_".length);
		$.ajax({
			type : 'POST',
			url : "addTeamUser.admin",
			data : {
				teamId : teamId
			}
		});
	});
	
	$("[id ^=submitDeleteTeamUser_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitDeleteTeamUser_".length);
		$.ajax({
			type : 'POST',
			url : "deleteTeamUser.admin",
			data : {
				teamId : teamId
			}
		});
	});
	
	$("[id ^=submitAddUserInTeam_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitAddUserInTeam_".length);
		var usernameSelected = $("#usernameChoice").val();
		$.ajax({
			type : 'POST',
			url : "addUserInTeam.admin",
			data : {
				teamId : teamId,
				usernameSelected : usernameSelected
			}
		});
	});

	$("[id ^=submitDeleteUserInTeam_]").click(function() {
		var id = $(this).attr("id");
		var teamId = id.substring("submitDeleteUserInTeam_".length);
		var usernameSelected = $("#usernameChoiceForDelete").val();
		$.ajax({
			type : 'POST',
			url : "deleteUserInTeam.admin",
			data : {
				teamId : teamId,
				usernameSelected : usernameSelected
			}
		});
	});
	
	$(document).ready(function() {
		$('.dataTables').dataTable( {
			"bJQueryUI": true	
			} );
	} );
</script>