
package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class User.
 */
@Entity
@Table(name = "USER_TABLE")
public class User implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4857119443710048796L;
	
	/** The user id. */
	@Id // Tells the user that this is the primary key.
	@Column(name = "USER_ID")
	private int userId;
	
	/** The username. */
	@NotEmpty(message = "Please enter a username")
	@Size(min = 4, max = 20)
	@Column(name = "USER_NAME")
	private String username;
	
	/** The password. */
	@NotEmpty
	@Column(name = "PASS_WORD")
	private String password;
	
	/** The items. */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
	private List<UserItem> items;
	
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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<UserItem> getItems() {
		
		return items;
	}
	
	/**
	 * Sets the items.
	 *
	 * @param items
	 *            the new items
	 */
	public void setItems(List<UserItem> items) {
		
		this.items = items;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "User [userId="
				+ userId
				+ ", username="
				+ username
				+ ", password="
				+ password
				+ ", items="
				+ items
				+ "]";
	}
	
	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userId
	 *            the user id
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @param items
	 *            the items
	 */
	public User(int userId, String username, String password,
			List<UserItem> items) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.items = items;
	}
	
	/**
	 * To JSON.
	 *
	 * @return the string
	 */
	public String toJSON() {
		
		return "{\"userId\" : \""
				+ userId
				+ "\","
				+ "\"username\" : \""
				+ username
				+ "\","
				+ "\"password\" : \""
				+ password
				+ "\""
				+ "}";
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
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
		User other = (User) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
