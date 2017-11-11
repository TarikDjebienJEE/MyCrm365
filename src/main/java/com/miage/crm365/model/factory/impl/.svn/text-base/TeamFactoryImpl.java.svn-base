package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.Team;
import com.miage.crm365.model.factory.ITeamFactory;

@Component(value = "teamFactory")
public class TeamFactoryImpl implements ITeamFactory{

	public Team createTeam() {
		return new Team();
	}

	public void setAll(Team team, String description) {
		team.setTeamDescription(description);	
	}

}
