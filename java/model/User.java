package model;

public class User {
 
	private String username;
	private String password;
	private byte [] document;
	private byte [] picture;
	private String email;
	
	
	
	
	public User(String username, String password, byte[] document, byte[] picture, String email) {
		super();
		this.username = username;
		this.password = password;
		this.document = document;
		this.picture = picture;
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getDocument() {
		return document;
	}
	public void setDocument(byte[] document) {
		this.document = document;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
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
	
	
}
