package com.miage.crm365.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miage.crm365.enumeration.ERole;
import com.miage.crm365.model.service.IMessageI18nService;
import com.miage.crm365.utils.CRM365Constants;

/**
 * Authentification Controller
 *
 * @version 1.1
 * @author Tarik Djebien
 * @author Eric Rakotobe
 */
@Controller
@RequestMapping(value = "*.do")
@Scope(value = "singleton")
public class LoginController {

	@Resource(name = "messageI18nService")
	private IMessageI18nService i18nService;
	

	/**
	 * Handler for valid login
	 *
	 * @return the JSP login.jsp
	 * @author tarik
	 */
	@RequestMapping("/login")
	public String getLogin() {
		return CRM365Constants.VIEW_LOGIN;
	}

	/**
	 * Handler for invalid login
	 *
	 * @return the JSP home.jsp
	 * @author tarik
	 */
	@RequestMapping("/loginValid")
	public String authentificationSuccess(HttpServletRequest request, ModelMap model) {

		// GET USER
		UsernamePasswordAuthenticationToken userPrincipal = (UsernamePasswordAuthenticationToken) request.getUserPrincipal();

		userPrincipal.getName();

		userPrincipal.getAuthorities();

		// CHECK SECURITY PERMISSION
		if (isUserInRoles(request)) {
			// Goto home page for authenticated user
			return CRM365Constants.VIEW_HOME;
		} else {
			// GOTO REDIRECTION VIEW FOR HACKER
			return CRM365Constants.VIEW_LOGIN;
		}
	}

	/**
	 * @return the JSP login.jsp
	 * @author tarik
	 */
	@RequestMapping("/loginInvalid")
	public String authentificationFailure(HttpServletRequest request, ModelMap model) {
		// FILL MODEL
		String errorLogin = i18nService.getMessage("authentificationFailure", null, null);
		model.put("errorLogin", errorLogin);

		// GOTO REDIRECTION VIEW
		return CRM365Constants.VIEW_LOGIN;
	}
	
	/**
	 * Check if user is authorized to connect
	 * @param request HTTP request
	 * @return TRUE if user can connect to CRM365 , else FALSE.
	 */
	private boolean isUserInRoles(HttpServletRequest request){
		List<String> rolesExisting = new LinkedList<String>();
		for(ERole role : ERole.values()){
			rolesExisting.add(role.getAuthoritiesSpringSecurity());
		}
		for(String roleEnable : rolesExisting){
			if(request.isUserInRole(roleEnable)){
				return true;
			}
		}
		return false;
	}

}