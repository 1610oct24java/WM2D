package com.revature.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_TABLE")
public class Item implements Serializable{

	private static final long serialVersionUID = 8000810783428140339L;
	@Id
	@Column(name="ITEM_ID")
	private int item_id;
	
	@Column(name="ITEM_NAME")
	private String item_name;

//	@OneToMany(mappedBy = "primaryKey.item",
//			cascade = CascadeType.ALL)
//	private List<UserItem> users;
	
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item_id;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		Item other = (Item) obj;
		if (item_id != other.item_id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + "]";
	}

	public Item(int item_id, String item_name) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
	}

	public Item() {
		super();
	}
	
	
}