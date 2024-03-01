package model;

import javax.print.DocFlavor.BYTE_ARRAY;

public class Studentinfo {

	private String email;
	private byte[] picture;
	private byte[] document;
	
	
	public Studentinfo(String email, byte[] picture, byte[] document) {
		super();
		this.email = email;
		this.picture = picture;
		this.document = document;
	}
	
	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public byte[] getDocument() {
		return document;
	}


	public void setDocument(byte[] document) {
		this.document = document;
	}
	
	
	
}
