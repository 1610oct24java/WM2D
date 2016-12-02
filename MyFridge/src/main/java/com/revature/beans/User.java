package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable{

	private static final long serialVersionUID = -4857119443710048796L;
	
	@Id //Tells the user that this is the primary key.
	@Column(name="USER_ID")
	private int user_id;
	
	@Column(name="USER_NAME")
	private String user_name;
	
	@Column(name="PASS_WORD")
	private String pass_word;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", pass_word=" + pass_word + "]";
	}
	public User(int user_id, String user_name, String pass_word) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
