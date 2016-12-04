package com.revature.beans;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="USER_TABLE")
public class User implements Serializable{
    private static final long serialVersionUID = -4857119443710048796L;
    
    @Id //Tells the user that this is the primary key.
    @Column(name="USER_ID")
    private int userId;
    
    @NotEmpty(message="Please enter a username")
	@Size(min=4, max=20)
    @Column(name="USER_NAME")
    private String username;
    
    @NotEmpty
    @Column(name="PASS_WORD")
    private String password;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="userId")
    private List<UserItem> items;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<UserItem> getItems() {
        return items;
    }
    public void setItems(List<UserItem> items) {
        this.items = items;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", items=" + items
                + "]";
    }
    public User() {
        super();
    }
    public User(int userId, String username, String password, List<UserItem> items) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.items = items;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + userId;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        User other = (User) obj;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userId != other.userId)
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}
