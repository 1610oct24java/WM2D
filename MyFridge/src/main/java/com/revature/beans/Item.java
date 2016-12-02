package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ITEM_TABLE")
public class Item implements Serializable{

	private static final long serialVersionUID = 8000810783428140339L;
	@Id
	@Column(name="ITEM_ID")
	private int item_id;
	
	@Column(name="MEASURE_TYPE")
	private String measure_type;
	
	@Column(name="MEASURE_AMOUNT")
	private double measure_amount;
	
	@Column(name="EXPIRATION_DATE")
	private String expiration_date;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="ITEM_DETAILS")
	private String item_details;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getMeasure_type() {
		return measure_type;
	}

	public void setMeasure_type(String measure_type) {
		this.measure_type = measure_type;
	}

	public double getMeasure_amount() {
		return measure_amount;
	}

	public void setMeasure_amount(double measure_amount) {
		this.measure_amount = measure_amount;
	}

	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getItem_details() {
		return item_details;
	}

	public void setItem_details(String item_details) {
		this.item_details = item_details;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((expiration_date == null) ? 0 : expiration_date.hashCode());
		result = prime * result + ((item_details == null) ? 0 : item_details.hashCode());
		result = prime * result + item_id;
		long temp;
		temp = Double.doubleToLongBits(measure_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((measure_type == null) ? 0 : measure_type.hashCode());
		result = prime * result + status;
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
		if (item_id != other.item_id)
			return false;
		if (Double.doubleToLongBits(measure_amount) != Double.doubleToLongBits(other.measure_amount))
			return false;
		if (measure_type == null) {
			if (other.measure_type != null)
				return false;
		} else if (!measure_type.equals(other.measure_type))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", measure_type=" + measure_type + ", measure_amount=" + measure_amount
				+ ", expiration_date=" + expiration_date + ", status=" + status + ", item_details=" + item_details
				+ "]";
	}

	public Item(int item_id, String measure_type, double measure_amount, String expiration_date, int status,
			String item_details) {
		super();
		this.item_id = item_id;
		this.measure_type = measure_type;
		this.measure_amount = measure_amount;
		this.expiration_date = expiration_date;
		this.status = status;
		this.item_details = item_details;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}