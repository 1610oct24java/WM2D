
package com.revature.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Item.
 */
@Entity
@Table(name = "ITEM_TABLE")
public class Item implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8000810783428140339L;
	
	/** The item id. */
	@Id
	@Column(name = "ITEM_ID")
	private int itemId;
	
	/** The item name. */
	@Column(name = "ITEM_NAME")
	private String itemName;
	
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
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		
		return itemName;
	}
	
	/**
	 * Sets the item name.
	 *
	 * @param itemName
	 *            the new item name
	 */
	public void setItemName(String itemName) {
		
		this.itemName = itemName;
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
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
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
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Item [itemId=" + itemId + ", itemName=" + itemName + "]";
	}
	
	/**
	 * Instantiates a new item.
	 *
	 * @param itemId
	 *            the item id
	 * @param itemName
	 *            the item name
	 */
	public Item(int itemId, String itemName) {
		this();
		this.itemId = itemId;
		this.itemName = itemName;
	}
	
	/**
	 * Instantiates a new item.
	 */
	public Item() {
		super();
	}
	
	/**
	 * To JSON.
	 *
	 * @return the string
	 */
	public String toJSON() {
		
		return "{\"itemId\" : \""
				+ itemId
				+ "\","
				+ "\"itemName\" : \""
				+ itemName
				+ "\""
				+ "}";
	}
}