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
@Entity
@Table(name="RECIPE_TABLE")
public class Recipe {
    
    @Id
    @Column(name="RECIPE_ID")
    private int recipeId;
    
    @Column(name="RECIPE_NAME")
    private String recipeName;
    
    @Column(name="RECIPE_DESCRIPTION")
    private String recipeDescription;
    
    @Column(name="RECIPE_URL")
    private String recipeUrl;
    
    @Column(name="IMAGE_ID")
    private int imgId;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="RECIPE_ITEM_TABLE", 
                joinColumns=@JoinColumn(name="RECIPE_ID"),
                inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
    private List<Item> items;
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public int getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getRecipeDescription() {
        return recipeDescription;
    }
    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }
    public String getRecipeUrl() {
        return recipeUrl;
    }
    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }
    public int getImgId() {
        return imgId;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
    
    public String toJSON() {
    	return "{\"recipeId\" : \"" + recipeId + "\","
    			+ "\"recipeName\" : \"" + recipeName + "\","
    			+ "\"recipeDescription\" : \"" + recipeDescription + "\","
    			+ "\"recipeUrl\" : \"" + recipeUrl + "\","
    			+ "\"imgId\" : \"" + imgId + "\","
    			+ "\"items\" : \"" + items +"\""
    			+ "}";
    }
    
    public Recipe(int recipeId, String recipeName, String recipeDescription, String recipeUrl, int imgId,
            List<Item> items) {
        super();
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeUrl = recipeUrl;
        this.imgId = imgId;
        this.items = items;
    }
    public Recipe() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", recipeDescription="
                + recipeDescription + ", recipeUrl=" + recipeUrl + ", imgId=" + imgId + ", items=" + items + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + imgId;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((recipeDescription == null) ? 0 : recipeDescription.hashCode());
        result = prime * result + recipeId;
        result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
        result = prime * result + ((recipeUrl == null) ? 0 : recipeUrl.hashCode());
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