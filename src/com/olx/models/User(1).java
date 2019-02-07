package com.olx.models;

public class User {
	 private int user_id;
     private String name;
     private String email;
     private long phone_number;
     private String password;
     private String deleted;
     
     
     
	public User() {
		super();
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public long getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
     
     
     
}