<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- Import --%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.miage.crm365.model.entity.User" %>
<%@ page import="com.miage.crm365.model.entity.Team" %>
<%@ page import="com.miage.crm365.model.entity.Authorities" %>
<%@ page import="com.miage.crm365.utils.CRM365Constants" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%-- Variables --%>
<%
	List<User> users = (List<User>) request.getAttribute("users");
	List<Team> teams = (List<Team>) request.getAttribute("teams");
	List<String> roles = (List<String>) request.getAttribute("roles");
	
	Map<User, List<String>> usersAndAuthorities = (Map<User, List<String>>) request.getAttribute("usersAndAuthorities");
	Map<User, List<String>> usersAndTeams = (Map<User, List<String>>) request.getAttribute("usersAndTeams");
	boolean infoUsersExisting = Boolean.parseBoolean((String) request.getAttribute("infoUsersExisting"));
	
	Boolean administrationServiceCreate = (Boolean) request.getAttribute("administrationServiceCreate");
	Boolean administrationServiceSave = (Boolean) request.getAttribute("administrationServiceSave");
	Boolean administrationServiceDeleteUser = (Boolean) request.getAttribute("administrationServiceDeleteUser");
%>
<%-- HTML5 --%>
<div id="articleTab">
	<ul>
		<li><a id="tabCreateUser" href="#createUser"><spring:message code="admin.Tab.UserCreation" /></a></li>
		<li><a id="tabManageUser" href="#manageUser"><spring:message code="admin.Tab.UserManagement" /></a></li>
	</ul>

<%-- CREATE USER --%>
<section id="createUser">
	<h1><spring:message code="admin.createUser.title" /></h1>
	<% if(administrationServiceCreate != null && administrationServiceCreate) { %>
		<p class="ui-state-highlight"><spring:message code="admin.administrationServiceCreate" /></p>
	<% } %>
	<table>
		<tr>
			<td><label><spring:message code="admin.createUser.userName" /></label></td>
			<td><input id="createUserName" type="text" name="createUserName" size="25" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="admin.createUser.passWord" /></label></td>
			<td><input id="createUserPassword" type="text" name="createUserPassword" size="30" /></td>
		</tr>
		<% if(roles!=null && !roles.isEmpty()) { %>
		<tr>
			<td><label><spring:message code="admin.createUser.role" /></label></td>
			<td>
				<select id="roleChoice">
					<%for(String role : roles){ %>
						<option value="<%=role%>"><%=role%></option>
					<%}%>
				</select>
			</td>
		</tr>
		<%}%>
		<% if(teams!= null && !teams.isEmpty()) { %>
		<tr>
			<td><label id="team"><spring:message code="admin.createUser.team" /></label></td>
			<td>
				<select id="teamChoice">
					<%for(Team team : teams){ %>
						<option value="<%=team.getTeamId()%>"><%=team.getTeamDescription()%></option>
					<%}%>
				</select>
			</td>
		</tr>
		<%}%>
		<tr>
			<td>
				<input id="submitCreateUser" type="submit" value="Create new User" /> 
			</td>
		</tr>
	</table>
</section>
	
<%-- MANAGE USER --%>
<section id="manageUser">
	<h1><spring:message code="admin.manageUser.title" /></h1>
	<% if(administrationServiceSave != null && administrationServiceSave) { %>
		<p class="ui-state-highlight"><spring:message code="admin.administrationServiceSave" /></p>
	<% } %>
	<% if(administrationServiceDeleteUser != null && administrationServiceDeleteUser) { %>
		<p class="ui-state-highlight"><spring:message code="admin.administrationServiceDeleteUser" /></p>
	<% } %>
	<table class="dataTables">
		<thead>
			<tr>
				<th><spring:message code="admin.manageUser.userName" /></th>
				<th><spring:message code="admin.manageUser.passWord" /></th>
				<th><spring:message code="admin.manageUser.enabled" /></th>
				<th><spring:message code="admin.manageUser.role" /></th>
				<th><spring:message code="admin.manageUser.team" /></th>
				<th><spring:message code="admin.manageUser.save" /></th>
				<th><spring:message code="admin.manageUser.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<%
				if (infoUsersExisting) {
			%>
				<%
					for (User user : users) {
				%>
				<tr>
					<td>
						<input id="username" type="text" value="<%=user.getUsername()%>" size="10"/>
						<span style="visibility: hidden; display: none;"><%=user.getUsername()%></span>
					</td>
					<td>
						<input id="password<%="_" + user.getUsername()%>" type="text" value="<%=user.getPassword()%>" size="10"/>
						<span style="visibility: hidden; display: none;"><%=user.getPassword()%></span>
					</td>
					<td>
						<select id="enable<%="_" + user.getUsername()%>">
							<option  <%if (user.isEnabled()) {%><%="selected='selected'"%><%}%> value="<%=CRM365Constants.USER_ENABLE%>">Yes</option>
							<option  <%if (!user.isEnabled()) {%><%="selected='selected'"%><%}%> value="<%=CRM365Constants.USER_DISABLE%>">No</option>
						</select> 
					</td>
					<td>
						<ul>
						<%
							for (String authority : usersAndAuthorities.get(user)) {
						%>
							<li><%=authority%></li>
						<%
							}
						%>
						</ul>
					</td>
					<td>
						<ul>
						<%
							for (String team : usersAndTeams.get(user)) {
						%>
							<li><%=team%></li>
						<%
							}
						%>
						</ul>
					</td>
					<td><input id="submitSaveUser<%="_" + user.getUsername()%>" type="submit" value="Save User" /></td>
					<td><input id="submitDeleteUser<%="_" + user.getUsername()%>" type="submit" value="Delete User" /></td>
				</tr>
				<%
					}
				%>
			<%
				}
			%>
		</tbody>
	</table>
</section>

</div>

<%-- JavaScript --%>
<script type="text/javascript" charset="utf-8">


	
	$("#submitCreateUser").click(
			function() {
				$.ajax({
					type : 'POST',
					url : "createUser.admin",
					data : {
						createUserName : $("#createUserName").val(),
						createUserPassword : $("#createUserPassword").val(),
						roleChoice : $("#roleChoice").val(),
						teamChoice : $("#teamChoice").val()
					}
				});
			});

	$("[id ^=submitSaveUser_]").click(function() {
		var id = $(this).attr("id");
		var username = id.substring("submitSaveUser_".length);
		$.ajax({
			type : 'POST',
			url : "saveUser.admin",
			data : {
				username : username,
				password : $("#password_" + username).val(),
				isEnable : $("#enable_" + username).val()
			}
		});
	});

	$("[id ^=submitDeleteUser_]").click(function() {
		var id = $(this).attr("id");
		var username = id.substring("submitDeleteUser_".length);
		$.ajax({
			type : 'POST',
			url : "deleteUser.admin",
			data : {
				username : username
			}
		});
	});
	
	$('.dataTables').dataTable( {"bJQueryUI": true} );
</script>
