package com.revature.beans;

import java.nio.file.Path;

public class Recipe { 
	
	private int recipe_id;
	private String recipe_name;
	private String recipe_link;
	private String recipe_details;
	private Path recipe_img;
	private String file_type;
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
	public String getRecipe_link() {
		return recipe_link;
	}
	public void setRecipe_link(String recipe_link) {
		this.recipe_link = recipe_link;
	}
	public String getRecipe_details() {
		return recipe_details;
	}
	public void setRecipe_details(String recipe_details) {
		this.recipe_details = recipe_details;
	}
	public Path getRecipe_img() {
		return recipe_img;
	}
	public void setRecipe_img(Path recipe_img) {
		this.recipe_img = recipe_img;
	}
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file_type == null) ? 0 : file_type.hashCode());
		result = prime * result + ((recipe_details == null) ? 0 : recipe_details.hashCode());
		result = prime * result + recipe_id;
		result = prime * result + ((recipe_img == null) ? 0 : recipe_img.hashCode());
		result = prime * result + ((recipe_link == null) ? 0 : recipe_link.hashCode());
		result = prime * result + ((recipe_name == null) ? 0 : recipe_name.hashCode());
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
		if (file_type == null) {
			if (other.file_type != null)
				return false;
		} else if (!file_type.equals(other.file_type))
			return false;
		if (recipe_details == null) {
			if (other.recipe_details != null)
				return false;
		} else if (!recipe_details.equals(other.recipe_details))
			return false;
		if (recipe_id != other.recipe_id)
			return false;
		if (recipe_img == null) {
			if (other.recipe_img != null)
				return false;
		} else if (!recipe_img.equals(other.recipe_img))
			return false;
		if (recipe_link == null) {
			if (other.recipe_link != null)
				return false;
		} else if (!recipe_link.equals(other.recipe_link))
			return false;
		if (recipe_name == null) {
			if (other.recipe_name != null)
				return false;
		} else if (!recipe_name.equals(other.recipe_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", recipe_name=" + recipe_name + ", recipe_link=" + recipe_link
				+ ", recipe_details=" + recipe_details + ", recipe_img=" + recipe_img + ", file_type=" + file_type
				+ "]";
	}
	public Recipe(int recipe_id, String recipe_name, String recipe_link, String recipe_details, Path recipe_img,
			String file_type) {
		super();
		this.recipe_id = recipe_id;
		this.recipe_name = recipe_name;
		this.recipe_link = recipe_link;
		this.recipe_details = recipe_details;
		this.recipe_img = recipe_img;
		this.file_type = file_type;
	}
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	} 
	

}
