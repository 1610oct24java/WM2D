package com.revature.dao;

import com.revature.beans.Item;

public interface ItemDAO {
	Item getItem(int id);
	void insertItem(Item item);
}
