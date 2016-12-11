package com.revature.dao;

import com.revature.beans.UserItem;

public interface UserItemDAO {
	public void insertUserItem(UserItem ui);
	public UserItem getUserItemByIds(UserItem ui);
	public UserItem getUserItemByIdsForRemove(UserItem ui);
	public void updateUserItem(UserItem ui);
	public void updateUserItem1(UserItem ui);
}
