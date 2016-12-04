package com.revature.beans;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class UserItemId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID")
    int userId;
    
    @Column(name="ITEM_ID")
    int itemId;
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
    public UserItemId() {
        super();
        // TODO Auto-generated constructor stub
    }
    public UserItemId(int userId, int itemId) {
        super();
        this.userId = userId;
        this.itemId = itemId;
    }
    @Override
    public String toString() {
        return "UserItemId [userId=" + userId + ", itemId=" + itemId + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + userId;
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
        UserItemId other = (UserItemId) obj;
        if (itemId != other.itemId)
            return false;
        if (userId != other.userId)
            return false;
        return true;
    }
}
