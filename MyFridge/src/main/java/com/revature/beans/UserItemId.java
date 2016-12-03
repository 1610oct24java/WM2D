package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserItemId implements Serializable{
	@Column(name="USER_ID")
	int user_id;
	
	@Column(name="ITEM_ID")
	int item_id;
	
	
	
}
