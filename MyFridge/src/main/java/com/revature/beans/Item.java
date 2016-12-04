package com.revature.beans;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="ITEM_TABLE")
public class Item implements Serializable{
    private static final long serialVersionUID = 8000810783428140339L;
    @Id
    @Column(name="ITEM_ID")
    private int itemId;
    
    @Column(name="ITEM_NAME")
    private String itemName;
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
        if (itemId != other.itemId)
            return false;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", itemName=" + itemName + "]";
    }
    public Item(int itemId, String itemName) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
    }
    public Item() {
        super();
    }   
}