package com.revature.beans;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int user_item_id;

	@Column(name = "USER_ID")
	private int user_id;

	@Column(name = "ITEM_ID")
	private int item_id;

	@Column(name = "ITEM_STATUS")
	private int item_status;

	@Column(name = "MEASURE_AMOUNT")
	private double measure_amount;

	@Column(name = "EXPIRATION_DATE")
	private String expiration_date;

	@Column(name = "MEASURE_TYPE")
	private String measure_type;

	@Column(name = "ITEM_DETAILS")
	private String item_details;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getItem_status() {
		return item_status;
	}

	public void setItem_status(int item_status) {
		this.item_status = item_status;
	}

	public double getMeasure_ammount() {
		return measure_amount;
	}

	public void setMeasure_ammount(double measure_ammount) {
		this.measure_amount = measure_ammount;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public String getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(String measure_type) {
		this.measure_type = measure_type;
	}

	public String getItem_details() {
		return item_details;
	}

	public void setItem_details(String item_details) {
		this.item_details = item_details;
	}

	public int getUser_item_id() {
		return user_item_id;
	}

	public void setUser_item_id(int user_item_id) {
		this.user_item_id = user_item_id;
	}

	public double getMeasure_amount() {
		return measure_amount;
	}

	public void setMeasure_amount(double measure_amount) {
		this.measure_amount = measure_amount;
	}

	public UserItem(int user_item_id, int item_status, double measure_amount, String expiration_date,
			String measure_type, String item_details) {
		super();
		this.user_item_id = user_item_id;
		this.item_status = item_status;
		this.measure_amount = measure_amount;
		this.expiration_date = expiration_date;
		this.measure_type = measure_type;
		this.item_details = item_details;
	}



	@Override
	public String toString() {
		return "UserItem [user_item_id=" + user_item_id + ", user_id=" + user_id + ", item_id=" + item_id
				+ ", item_status=" + item_status + ", measure_amount=" + measure_amount + ", expiration_date="
				+ expiration_date + ", measure_type=" + measure_type + ", item_details=" + item_details + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiration_date == null) ? 0 : expiration_date.hashCode());
		result = prime * result + ((item_details == null) ? 0 : item_details.hashCode());
		result = prime * result + item_status;
		long temp;
		temp = Double.doubleToLongBits(measure_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((measure_type == null) ? 0 : measure_type.hashCode());
		result = prime * result + user_item_id;
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
		UserItem other = (UserItem) obj;
		if (expiration_date == null) {
			if (other.expiration_date != null)
				return false;
		} else if (!expiration_date.equals(other.expiration_date))
			return false;
		if (item_details == null) {
			if (other.item_details != null)
				return false;
		} else if (!item_details.equals(other.item_details))
			return false;
		if (item_status != other.item_status)
			return false;
		if (Double.doubleToLongBits(measure_amount) != Double.doubleToLongBits(other.measure_amount))
			return false;
		if (measure_type == null) {
			if (other.measure_type != null)
				return false;
		} else if (!measure_type.equals(other.measure_type))
			return false;
		if (user_item_id != other.user_item_id)
			return false;
		return true;
	}

	public UserItem(int user_id, int item_id, int item_status, double measure_ammount, String expiration_date,
			String measure_type, String item_details) {
		super();
		this.item_status = item_status;
		this.measure_amount = measure_ammount;
		this.expiration_date = expiration_date;
		this.measure_type = measure_type;
		this.item_details = item_details;
	}

	public UserItem() {
		super();
	}

}
