package com.revature.dao;

import com.revature.beans.User;

public interface UserDAO {
	void createUser(User user);
	User getUser(int userId);
}
