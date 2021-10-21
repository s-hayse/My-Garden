package com.mygarden.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gardener")
public class Gardener {
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Id
	@Column(name="email")
	private String email; //make email and password required
	
	@Column(name="password")
	private String password;
	
	@Column(name="zone")
	private String zone; //climate zone
	
	@Column(name="picture")
	private Blob picture;
	
	@Column(name="picture_name")
	private String picture_name;
	
	public String getPicture_name() {
		return picture_name;
	}

	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}


}
