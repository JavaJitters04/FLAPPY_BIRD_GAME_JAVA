package com.user.model;

public class User {
     
	 private int id;
	 private String username;
	 private String password;
	 private String email;
	 private String country;
	 private int high_score;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String email, String country, int high_score) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.high_score = high_score;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getHigh_score() {
		return high_score;
	}
	public void setHigh_score(int high_score) {
		this.high_score = high_score;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", country=" + country + ", high_score=" + high_score + "]";
	}
	 
	 
}
