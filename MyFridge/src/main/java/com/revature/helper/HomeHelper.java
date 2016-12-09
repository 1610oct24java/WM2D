
package com.revature.helper;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItem;
import com.revature.dao.ItemDAO;
import com.revature.dao.ItemDAOimpl;
import com.revature.dao.UserItemDAO;
import com.revature.dao.UserItemDAOimpl;

/**
 * The Class HomeHelper.
 */
public class HomeHelper {

	public static User addItem(UserItem ui, HttpSession session) {
		ItemDAO iDao = new ItemDAOimpl();
		UserItemDAO uiDao = new UserItemDAOimpl();
		Item i = iDao.getItemByName(ui.getItemId().getItemName()); // see if the current item exists
		User user = (User) session.getAttribute("currentUser");
		List<UserItem> list = user.getItems(); // get User's list of items
		Item newItem = i;
		ui.setUserId(user.getUserId()); // set UserItem's userId to the current User
		if(i == null) { //if item doesnt exist in DB
			System.out.println("i == null");
			newItem = new Item();
			newItem.setItemName(ui.getItemId().getItemName());
			iDao.insertItem(newItem); // Add item to DB
			newItem = iDao.getItemByName(newItem.getItemName()); // Get ItemId from DB
			ui.setItemId(newItem);
			uiDao.insertUserItem(ui); // add userItem to useritem table
			list.add(ui); // update user list of items
			user.setItems(list);
		} else { // else item exists in DB
			System.out.println("i != null");
			ui.setItemId(newItem); //update UserItem's item
			UserItem newUI = uiDao.getUserItemByIds(ui); // Check if UserItem already exists
			System.out.println();
			if(newUI == null) { //if item isn't connected to user
				uiDao.insertUserItem(ui);
				list.add(ui);
				user.setItems(list);
			} else {
				//ALREADY EXISTS IN LIST
				//DO SOMETHING HERE AT SOME POINT
			}
		}
		session.setAttribute("currentUser", user);
		return user;
	}
	
}
