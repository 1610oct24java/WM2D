package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RECIPE_TABLE")
public class Recipe {
	
	@Id
	@Column(name="RECIPE_ID")
	private int recipe_id;
	
	@Column(name="RECIPE_NAME")
	private String recipe_name;
	
	@Column(name="RECIPE_DESCRIPTION")
	private String recipe_description;
	
	@Column(name="RECIPE_URL")
	private String recipe_url;
	
	@Column(name="IMAGE_ID")
	private int img_id;

	public int getRecipe_id() {
		return recipe_id;
	}
	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public String getRecipe_description() {
		return recipe_description;
	}
	public void setRecipe_description(String recipe_description) {
		this.recipe_description = recipe_description;
	}
	public String getRecipe_url() {
		return recipe_url;
	}
	public void setRecipe_url(String recipe_url) {
		this.recipe_url = recipe_url;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + img_id;
		result = prime * result + ((recipe_description == null) ? 0 : recipe_description.hashCode());
		result = prime * result + recipe_id;
		result = prime * result + ((recipe_name == null) ? 0 : recipe_name.hashCode());
		result = prime * result + ((recipe_url == null) ? 0 : recipe_url.hashCode());
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
		Recipe other = (Recipe) obj;
		if (img_id != other.img_id)
			return false;
		if (recipe_description == null) {
			if (other.recipe_description != null)
				return false;
		} else if (!recipe_description.equals(other.recipe_description))
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		if (recipe_name == null) {
			if (other.recipe_name != null)
				return false;
		} else if (!recipe_name.equals(other.recipe_name))
			return false;
		if (recipe_url == null) {
			if (other.recipe_url != null)
				return false;
		} else if (!recipe_url.equals(other.recipe_url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", recipe_description="
				+ recipe_description + ", recipe_url=" + recipe_url + ", img_id=" + img_id + "]";
	}
	public Recipe(int recipe_id, String recipe_name, String recipe_description, String recipe_url, int img_id) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.recipe_description = recipe_description;
		this.recipe_url = recipe_url;
		this.img_id = img_id;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
}
