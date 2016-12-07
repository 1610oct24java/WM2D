
package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UserItem.
 */
@Entity
@Table(name = "USER_ITEM_TABLE")
// @AssociationOverrides({
// @AssociationOverride(name="primaryKey.user",
// joinColumns = @JoinColumn(name="USER_ID")),
// @AssociationOverride(name="primaryKey.item",
// joinColumns = @JoinColumn(name="ITEM_ID"))
// })
public class UserItem implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 161778175847291640L;
	
	/** The user item id. */
	@Id
	@Column(name = "USER_ITEM_ID")
	private int userItemId;
	
	/** The user id. */
	@Column(name = "USER_ID")
	private int userId;
	
	/** The item id. */
	@Column(name = "ITEM_ID")
	private int itemId;
	
	/** The item status. */
	@Column(name = "ITEM_STATUS")
	private int itemStatus;
	
	/** The measure amount. */
	@Column(name = "MEASURE_AMOUNT")
	private double measureAmount;
	
	/** The expiration date. */
	@Column(name = "EXPIRATION_DATE")
	private String expirationDate;
	
	/** The measure type. */
	@Column(name = "MEASURE_TYPE")
	private String measureType;
	
	/** The item details. */
	@Column(name = "ITEM_DETAILS")
	private String itemDetails;
	
	/**
	 * Gets the user item id.
	 *
	 * @return the user item id
	 */
	public int getUserItemId() {
		
		return userItemId;
	}
	
	/**
	 * Sets the user item id.
	 *
	 * @param userItemId
	 *            the new user item id
	 */
	public void setUserItemId(int userItemId) {
		
		this.userItemId = userItemId;
	}
	
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
	 * Gets the item status.
	 *
	 * @return the item status
	 */
	public int getItemStatus() {
		
		return itemStatus;
	}
	
	/**
	 * Sets the item status.
	 *
	 * @param itemStatus
	 *            the new item status
	 */
	public void setItemStatus(int itemStatus) {
		
		this.itemStatus = itemStatus;
	}
	
	/**
	 * Gets the measure amount.
	 *
	 * @return the measure amount
	 */
	public double getMeasureAmount() {
		
		return measureAmount;
	}
	
	/**
	 * Sets the measure amount.
	 *
	 * @param measureAmount
	 *            the new measure amount
	 */
	public void setMeasureAmount(double measureAmount) {
		
		this.measureAmount = measureAmount;
	}
	
	/**
	 * Gets the expiration date.
	 *
	 * @return the expiration date
	 */
	public String getExpirationDate() {
		
		return expirationDate;
	}
	
	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate
	 *            the new expiration date
	 */
	public void setExpirationDate(String expirationDate) {
		
		this.expirationDate = expirationDate;
	}
	
	/**
	 * Gets the measure type.
	 *
	 * @return the measure type
	 */
	public String getMeasureType() {
		
		return measureType;
	}
	
	/**
	 * Sets the measure type.
	 *
	 * @param measureType
	 *            the new measure type
	 */
	public void setMeasureType(String measureType) {
		
		this.measureType = measureType;
	}
	
	/**
	 * Gets the item details.
	 *
	 * @return the item details
	 */
	public String getItemDetails() {
		
		return itemDetails;
	}
	
	/**
	 * Sets the item details.
	 *
	 * @param itemDetails
	 *            the new item details
	 */
	public void setItemDetails(String itemDetails) {
		
		this.itemDetails = itemDetails;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "UserItem [userItemId="
				+ userItemId
				+ ", userId="
				+ userId
				+ ", itemId="
				+ itemId
				+ ", itemStatus="
				+ itemStatus
				+ ", measureAmount="
				+ measureAmount
				+ ", expirationDate="
				+ expirationDate
				+ ", measureType="
				+ measureType
				+ ", itemDetails="
				+ itemDetails
				+ "]";
	}
	
	/**
	 * Instantiates a new user item.
	 */
	public UserItem() {
		super();
	}
	
	/**
	 * Instantiates a new user item.
	 *
	 * @param userItemId
	 *            the user item id
	 * @param userId
	 *            the user id
	 * @param itemId
	 *            the item id
	 * @param itemStatus
	 *            the item status
	 * @param measureAmount
	 *            the measure amount
	 * @param expirationDate
	 *            the expiration date
	 * @param measureType
	 *            the measure type
	 * @param itemDetails
	 *            the item details
	 */
	public UserItem(int userItemId, int userId, int itemId, int itemStatus,
			double measureAmount, String expirationDate, String measureType,
			String itemDetails) {
		super();
		this.userItemId = userItemId;
		this.userId = userId;
		this.itemId = itemId;
		this.itemStatus = itemStatus;
		this.measureAmount = measureAmount;
		this.expirationDate = expirationDate;
		this.measureType = measureType;
		this.itemDetails = itemDetails;
	}
	
	/**
	 * To JSON.
	 *
	 * @return the string
	 */
	public String toJSON() {
		
		return "{userItemId : "
				+ userItemId
				+ "\","
				+ "\"userId\" : \""
				+ userId
				+ "\","
				+ "\"itemId\" : \""
				+ itemId
				+ "\","
				+ "\"itemStatus\" : \""
				+ itemStatus
				+ "\","
				+ "\"measureAmount\" : \""
				+ measureAmount
				+ "\","
				+ "\"expirationDate\" : \""
				+ expirationDate
				+ "\","
				+ "\"measureType\" : \""
				+ measureType
				+ "\","
				+ "\"itemDetails\" : \""
				+ itemDetails
				+ "\""
				+ "}";
	}
}