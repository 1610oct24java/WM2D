
package com.revature.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The Class UserItemId.
 */
@Embeddable
public class UserItemId implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user id. */
	@Column(name = "USER_ID")
	int userId;
	
	/** The item id. */
	@Column(name = "ITEM_ID")
	int itemId;
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(int userId) {
		
		this.userId = userId;
	}
	
	/**
	 * Gets the item id.
	 *
	 * @return the item id
	 */
	public int getItemId() {
		
		return itemId;
	}
	
	/**
	 * Sets the item id.
	 *
	 * @param itemId
	 *            the new item id
	 */
	public void setItemId(int itemId) {
		
		this.itemId = itemId;
	}
	
	/**
	 * Instantiates a new user item id.
	 */
	public UserItemId() {
		super();
	}
	
	/**
	 * Instantiates a new user item id.
	 *
	 * @param userId
	 *            the user id
	 * @param itemId
	 *            the item id
	 */
	public UserItemId(int userId, int itemId) {
		this();
		this.userId = userId;
		this.itemId = itemId;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "UserItemId [userId=" + userId + ", itemId=" + itemId + "]";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		result = prime * result + userId;
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserItemId other = (UserItemId) obj;
		if (itemId != other.itemId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
