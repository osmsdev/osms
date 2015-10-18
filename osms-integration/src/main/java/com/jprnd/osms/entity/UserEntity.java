package com.jprnd.osms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_TYPE")
	private int UserType;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@Column(name = "CREATED_AT")
	private Date createdAt;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "MODIFIED_AT")
	private Date modifiedAt;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	

}
