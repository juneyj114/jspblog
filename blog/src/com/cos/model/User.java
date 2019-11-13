package com.cos.model;

import java.sql.Timestamp;

public class User {

	private int id;
	private String userProfile; //이미지 경로(파일업로드)
	private String username;
	private String password;
	private String email;
	private Timestamp createDate;
	private String addr;
	private boolean mailValid;
	
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	public String getUserProfile() {
		return userProfile;
	}
	
	public boolean isMailValid() {
		return mailValid;
	}
	public void setMailValid(boolean mailValid) {
		this.mailValid = mailValid;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	public User(int id, String username, String password, String email, Timestamp createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createDate = createDate;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

}