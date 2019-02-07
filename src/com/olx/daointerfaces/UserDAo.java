package com.olx.daointerfaces;

import com.olx.models.User;

public interface UserDAo {
	int insertUser(User user);
	User getUser(String emailId);
}
