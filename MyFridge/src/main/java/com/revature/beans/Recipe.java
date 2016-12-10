
package com.revature.beans;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class Recipe.
 */
@Entity
@Table(name = "RECIPE_TABLE")
public class Recipe {
	
	/** The recipe id. */
	@Id
	@Column(name = "RECIPE_ID")
	private int recipeId;
	
	/** The recipe name. */
	@Column(name = "RECIPE_NAME")
	private String recipeName;
	
	/** The recipe description. */
	@Column(name = "RECIPE_DESCRIPTION")
	private String recipeDescription;
	
	/** The recipe url. */
	@Column(name = "RECIPE_URL")
	private String recipeUrl;
	
	/** The img id. */
	@Column(name = "IMAGE_ID")
	private int imgId;
	
	/** The items. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "RECIPE_ITEM_TABLE",
			joinColumns = @JoinColumn(name = "RECIPE_ID"),
			inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private List<Item> items;
	
	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public List<Item> getItems() {
		
		return items;
	}
	
	/**
	 * Sets the items.
	 *
	 * @param items
	 *            the new items
	 */
	public void setItems(List<Item> items) {
		
		this.items = items;
	}
	
	/**
	 * Gets the recipe id.
	 *
	 * @return the recipe id
	 */
	public int getRecipeId() {
		
		return recipeId;
	}
	
	/**
	 * Sets the recipe id.
	 *
	 * @param recipeId
	 *            the new recipe id
	 */
	public void setRecipeId(int recipeId) {
		
		this.recipeId = recipeId;
	}
	
	/**
	 * Gets the recipe name.
	 *
	 * @return the recipe name
	 */
	public String getRecipeName() {
		
		return recipeName;
	}
	
	/**
	 * Sets the recipe name.
	 *
	 * @param recipeName
	 *            the new recipe name
	 */
	public void setRecipeName(String recipeName) {
		
		this.recipeName = recipeName;
	}
	
	/**
	 * Gets the recipe description.
	 *
	 * @return the recipe description
	 */
	public String getRecipeDescription() {
		
		return recipeDescription;
	}
	
	/**
	 * Sets the recipe description.
	 *
	 * @param recipeDescription
	 *            the new recipe description
	 */
	public void setRecipeDescription(String recipeDescription) {
		
		this.recipeDescription = recipeDescription;
	}
	
	/**
	 * Gets the recipe url.
	 *
	 * @return the recipe url
	 */
	public String getRecipeUrl() {
		
		return recipeUrl;
	}
	
	/**
	 * Sets the recipe url.
	 *
	 * @param recipeUrl
	 *            the new recipe url
	 */
	public void setRecipeUrl(String recipeUrl) {
		
		this.recipeUrl = recipeUrl;
	}
	
	/**
	 * Gets the img id.
	 *
	 * @return the img id
	 */
	public int getImgId() {
		
		return imgId;
	}
	
	/**
	 * Sets the img id.
	 *
	 * @param imgId
	 *            the new img id
	 */
	public void setImgId(int imgId) {
		
		this.imgId = imgId;
	}
	
	/**
	 * To JSON.
	 *
	 * @return the string
	 */
	public String toJSON() {
		
		return "{\"recipeId\" : \""
				+ recipeId
				+ "\","
				+ "\"recipeName\" : \""
				+ recipeName
				+ "\","
				+ "\"recipeDescription\" : \""
				+ recipeDescription
				+ "\","
				+ "\"recipeUrl\" : \""
				+ recipeUrl
				+ "\","
				+ "\"imgId\" : \""
				+ imgId
				+ "\","
				+ "\"items\" : \""
				+ items
				+ "\""
				+ "}";
	}
	
	/**
	 * Instantiates a new recipe.
	 *
	 * @param recipeId
	 *            the recipe id
	 * @param recipeName
	 *            the recipe name
	 * @param recipeDescription
	 *            the recipe description
	 * @param recipeUrl
	 *            the recipe url
	 * @param imgId
	 *            the img id
	 * @param items
	 *            the items
	 */
	public Recipe(int recipeId, String recipeName, String recipeDescription,
			String recipeUrl, int imgId, List<Item> items) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.recipeDescription = recipeDescription;
		this.recipeUrl = recipeUrl;
		this.imgId = imgId;
		this.items = items;
	}
	
	/**
	 * Instantiates a new recipe.
	 */
	public Recipe() {
		super();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Recipe [recipeId="
				+ recipeId
				+ ", recipeName="
				+ recipeName
				+ ", recipeDescription="
				+ recipeDescription
				+ ", recipeUrl="
				+ recipeUrl
				+ ", imgId="
				+ imgId
				+ ", items="
				+ items
				+ "]";
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + imgId;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result
				+ ((recipeDescription == null)
						? 0
						: recipeDescription.hashCode());
		result = prime * result + recipeId;
		result = prime * result
				+ ((recipeName == null) ? 0 : recipeName.hashCode());
		result = prime * result
				+ ((recipeUrl == null) ? 0 : recipeUrl.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
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
		Recipe other = (Recipe) obj;
		if (imgId != other.imgId)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (recipeDescription == null) {
			if (other.recipeDescription != null)
				return false;
		} else if (!recipeDescription.equals(other.recipeDescription))
			return false;
		if (recipeId != other.recipeId)
			return false;
		if (recipeName == null) {
			if (other.recipeName != null)
				return false;
		} else if (!recipeName.equals(other.recipeName))
			return false;
		if (recipeUrl == null) {
			if (other.recipeUrl != null)
				return false;
		} else if (!recipeUrl.equals(other.recipeUrl))
			return false;
		return true;
	}
}