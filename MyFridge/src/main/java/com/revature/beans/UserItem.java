package com.revature.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "USER_ITEM_TABLE")
// @AssociationOverrides({
// @AssociationOverride(name="primaryKey.user",
// joinColumns = @JoinColumn(name="USER_ID")),
// @AssociationOverride(name="primaryKey.item",
// joinColumns = @JoinColumn(name="ITEM_ID"))
// })
public class UserItem {
    @Id
    @Column(name = "USER_ITEM_ID")
    private int userItemId;
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "ITEM_ID")
    private int itemId;
    @Column(name = "ITEM_STATUS")
    private int itemStatus;
    @Column(name = "MEASURE_AMOUNT")
    private double measureAmount;
    @Column(name = "EXPIRATION_DATE")
    private String expirationDate;
    @Column(name = "MEASURE_TYPE")
    private String measureType;
    @Column(name = "ITEM_DETAILS")
    private String itemDetails;
    public int getUserItemId() {
        return userItemId;
    }
    public void setUserItemId(int userItemId) {
        this.userItemId = userItemId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public int getItemStatus() {
        return itemStatus;
    }
    public void setItemStatus(int itemStatus) {
        this.itemStatus = itemStatus;
    }
    public double getMeasureAmount() {
        return measureAmount;
    }
    public void setMeasureAmount(double measureAmount) {
        this.measureAmount = measureAmount;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String getMeasureType() {
        return measureType;
    }
    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }
    public String getItemDetails() {
        return itemDetails;
    }
    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
    @Override
    public String toString() {
        return "UserItem [userItemId=" + userItemId + ", userId=" + userId + ", itemId=" + itemId + ", itemStatus="
                + itemStatus + ", measureAmount=" + measureAmount + ", expirationDate=" + expirationDate
                + ", measureType=" + measureType + ", itemDetails=" + itemDetails + "]";
    }
    public UserItem() {
        super();
    }
    public UserItem(int userItemId, int userId, int itemId, int itemStatus, double measureAmount, String expirationDate,
            String measureType, String itemDetails) {
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
    
    public String toJSON() {
    	return "{userItemId : " + userItemId + "\","
    			+ "\"userId\" : \"" + userId + "\","
    			+ "\"itemId\" : \"" + itemId + "\","
    			+ "\"itemStatus\" : \"" + itemStatus + "\","
    			+ "\"measureAmount\" : \"" + measureAmount + "\","
    			+ "\"expirationDate\" : \"" + expirationDate + "\","
    			+ "\"measureType\" : \"" + measureType + "\","
    			+ "\"itemDetails\" : \"" + itemDetails + "\""
    			+ "}";
    }
}