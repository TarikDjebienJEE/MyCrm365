package com.miage.crm365.model.factory;

import com.miage.crm365.model.entity.User;

public interface IUserFactory {
	
	User createUser();

	void setAll(User user, String username, String password, boolean isEnable);

}
