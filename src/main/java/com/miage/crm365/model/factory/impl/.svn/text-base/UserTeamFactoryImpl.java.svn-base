package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.UserTeam;
import com.miage.crm365.model.factory.IUserTeamFactory;

/**
 * 
 * @author rudy stienne
 *
 */
@Component(value = "userTeamFactory")
public class UserTeamFactoryImpl implements IUserTeamFactory{

	public UserTeam createUserTeam() {
		return new UserTeam();
	}

	public void setAll(UserTeam userTeam, String username, Long teamId) {
		userTeam.setUsername(username);
		userTeam.setTeamId(teamId);
	}

}
