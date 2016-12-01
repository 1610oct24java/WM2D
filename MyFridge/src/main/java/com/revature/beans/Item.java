package com.revature.beans;

public class Item {
	private int item_id;
	private String item_name;
	private String measure_type;
	private double measure_amount;
	private String expiration_date;
	private int Status;
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
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Status;
		result = prime * result + ((expiration_date == null) ? 0 : expiration_date.hashCode());
		result = prime * result + item_id;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(measure_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((measure_type == null) ? 0 : measure_type.hashCode());
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
		if (Status != other.Status)
			return false;
		if (expiration_date == null) {
			if (other.expiration_date != null)
				return false;
		} else if (!expiration_date.equals(other.expiration_date))
			return false;
		if (item_id != other.item_id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (Double.doubleToLongBits(measure_amount) != Double.doubleToLongBits(other.measure_amount))
			return false;
		if (measure_type == null) {
			if (other.measure_type != null)
				return false;
		} else if (!measure_type.equals(other.measure_type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", measure_type=" + measure_type
				+ ", measure_amount=" + measure_amount + ", expiration_date=" + expiration_date + ", Status=" + Status
				+ "]";
	}
	public Item(int item_id, String item_name, String measure_type, double measure_amount, String expiration_date,
			int status) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.measure_type = measure_type;
		this.measure_amount = measure_amount;
		this.expiration_date = expiration_date;
		Status = status;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
}
