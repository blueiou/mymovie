package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{
	private String roleid;  
    private String rolename;  
    private Integer ordernum;  
    private String description;  
    private Set users = new HashSet();  
  
    public Role() {  
        super();  
    }  
  
    public Role(String rolename) {
		super();
		this.rolename = rolename;
	}

	public String getRoleid() {  
        return roleid;  
    }  
  
    public void setRoleid(String roleid) {  
        this.roleid = roleid;  
    }  
  
    public String getRolename() {  
        return rolename;  
    }  
  
    public void setRolename(String rolename) {  
        this.rolename = rolename;  
    }  
  
    public Integer getOrdernum() {  
        return ordernum;  
    }  
  
    public void setOrdernum(Integer ordernum) {  
        this.ordernum = ordernum;  
    }  
  
    public String getDescription() {  
        return description;  
    }  
  
    public void setDescription(String description) {  
        this.description = description;  
    }  
  
    public Set getUsers() {  
        return users;  
    }  
  
    public void setUsers(Set users) {  
        this.users = users;  
    }  
}
