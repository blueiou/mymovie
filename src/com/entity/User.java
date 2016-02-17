package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	 private String email;

	 private Date createDate;

	 	private String userid;  
	     private String username;  
	     private String password;  
	     private UserInfo userInfo;
	     
	

		private Set roles = new HashSet(); 
		
		public UserInfo getUserInfo() {
			return userInfo;
		}
		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
	     public User() {  
	         super();  
	     }  
	   public User(String username){
	 	  this.username=username;
	   }
	 	public Date getCreateDate() {
	 	return createDate;
	 }
	 public void setCreateDate(Date createDate) {
	 	this.createDate = createDate;
	 }

	   public String getEmail() {
	 	return email;
	 }
	 public void setEmail(String email) {
	 	this.email = email;
	 }
	     public String getUserid() {  
	         return userid;  
	     }  
	   
	     public void setUserid(String userid) {  
	         this.userid = userid;  
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
	   
	     public Set getRoles() {  
	         return roles;  
	     }  
	   
	     public void setRoles(Set roles) {  
	         this.roles = roles;  
	     }  
	
	
	
}
