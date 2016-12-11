
package com.revature.helper;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserItem;
import com.revature.dao.ItemDAO;
import com.revature.dao.ItemDAOimpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;
import com.revature.dao.UserItemDAO;
import com.revature.dao.UserItemDAOimpl;

/**
 * The Class HomeHelper.
 */
public class HomeHelper {

	/******************************************************************************************************
	 * This is the method to add items to the fridge 
	 *****************************************************************************************************/
	
	public static User addItem(UserItem ui, HttpSession session) {
		ItemDAO iDao = new ItemDAOimpl();
		UserItemDAO uiDao = new UserItemDAOimpl();
		Item i = iDao.getItemByName(ui.getItemId().getItemName()); // see if the current item exists
		User user = (User) session.getAttribute("currentUser");
		List<UserItem> list = user.getItems(); // get User's list of items
		Item newItem = i;
		ui.setUserId(user.getUserId()); // set UserItem's userId to the current User
		ui.setExpirationDate(ui.getExpirationDate().split("T")[0]);
		if(i == null) { //if item doesnt exist in DB
			newItem = new Item();
			newItem.setItemName(ui.getItemId().getItemName());
			iDao.insertItem(newItem); // Add item to DB
			newItem = iDao.getItemByName(newItem.getItemName()); // Get ItemId from DB
			ui.setItemId(newItem);
			uiDao.insertUserItem(ui); // add userItem to useritem table
			list.add(ui); // update user list of items
			user.setItems(list);
		} else { // else item exists in DB
			ui.setItemId(newItem); //update UserItem's item
			UserItem newUI = uiDao.getUserItemByIds(ui); // Check if UserItem already exists
			if(newUI == null) { //if item isn't connected to user
				uiDao.insertUserItem(ui);
				list.add(ui);
				user.setItems(list);
			} else {
				System.out.println("EXISTING" + newUI);
				if(newUI.getItemStatus() != 1 || newUI.getItemStatus() != 2) {
					System.out.println("In here!");
					newUI.setItemStatus(1);
					uiDao.updateUserItem(newUI);
					list.add(newUI);
					user.setItems(list);
				}
				System.out.println("ALREADY EXISTS");
			}
		}
		session.setAttribute("currentUser", user);
		return user;
	}
	
	/******************************************************************************************************
	 * This is the method to add items to the shopping list
	 *****************************************************************************************************/
	
	public static User addItemToShoppingList(UserItem ui, HttpSession session) {
		ItemDAO iDao = new ItemDAOimpl();
		UserItemDAO uiDao = new UserItemDAOimpl();
		Item i = iDao.getItemByName(ui.getItemId().getItemName()); // see if the current item exists
		User user = (User) session.getAttribute("currentUser");
		List<UserItem> list = user.getItems(); // get User's list of items
		Item newItem = i;
		ui.setUserId(user.getUserId()); // set UserItem's userId to the current User
		if(i == null) { //if item doesnt exist in DB
			newItem = new Item();
			newItem.setItemName(ui.getItemId().getItemName());
			iDao.insertItem(newItem); // Add item to DB
			newItem = iDao.getItemByName(newItem.getItemName()); // Get ItemId from DB
			ui.setItemId(newItem);
			uiDao.insertUserItem(ui); // add userItem to useritem table
			list.add(ui); // update user list of items
			user.setItems(list);
		} else { // else item exists in DB
			ui.setItemId(newItem); //update UserItem's item
			UserItem newUI = uiDao.getUserItemByIdsForRemove(ui); // Check if UserItem already exists
			System.out.println("ADD UI: " + newUI);
			if(newUI == null) { //if item isn't connected to user
				uiDao.insertUserItem(ui);
				list.add(ui);
				user.setItems(list);
			} else {
				System.out.println("EXISTING" + newUI);
				if(newUI.getItemStatus() != 0 || newUI.getItemStatus() != 2) {
					System.out.println("In here!");
					newUI.setItemStatus(0);
					uiDao.updateUserItem(newUI);
					list.add(newUI);
					user.setItems(list);
				}
				System.out.println("ALREADY EXISTS");
			}
		}
		session.setAttribute("currentUser", user);
		return user;
	}
	
	
	public static User removeItemFromShoppingHelper(UserItem ui,HttpSession session){
		if(ui.getItemStatus()==2){
			ui.setItemStatus(1);
		}
		else{
			ui.setItemStatus(-1);
		}
		return updateStatus(ui,session);
	}

	public static User removeItemFromFridgeHelper(UserItem ui, HttpSession session) {
		
		if(ui.getItemStatus()==2){
		ui.setItemStatus(0); // set status to 0
		}
		else{
			ui.setItemStatus(-1);
		}
		return updateStatus(ui, session);
	}
	
	public static User updateStatus(UserItem ui, HttpSession session){
		UserItemDAO uiDao = new UserItemDAOimpl();
		System.out.println("REOMVED UI: " + ui);
		System.out.println("USERITEM_ID: " + ui.getUserItemId());
		UserItem userItem = uiDao.getUserItemByIdsForRemove(ui);
		userItem.setItemStatus(-1);
		System.out.println("REOMVED UI: " + userItem);
		uiDao.updateUserItem(userItem); // update current useritem
		UserDAO uDao = new UserDAOimpl();
		User currentUser = (User) session.getAttribute("currentUser"); // get currentUser
		User user = uDao.getUserByName(currentUser.getUsername()); // get user with updated item list
		session.setAttribute("currentUser", user);
		return user;
	}
}