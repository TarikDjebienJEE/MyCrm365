package com.miage.crm365.model.factory.impl;

import org.springframework.stereotype.Component;

import com.miage.crm365.model.entity.User;
import com.miage.crm365.model.factory.IUserFactory;

@Component(value = "userFactory")
public class UserFactoryImpl implements IUserFactory {

	public User createUser() {
		return new User();
	}

	public void setAll(User user, String username, String password,
			boolean isEnable) {
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(isEnable);
	}

}
