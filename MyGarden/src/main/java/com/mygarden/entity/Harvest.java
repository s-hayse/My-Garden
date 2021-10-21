package com.mygarden.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="harvest")
public class Harvest {
	
	@Id
	@Column(name="harvest_id")
	private int harvest_id;
	
	@Column(name="seed_type")
	private String seed_type;
	
	@Column(name="amount")
	private String amount; //drop down menu: "Pounds or Count"
	
	@Column(name="harvest_date")
	private Date harvest_date;
	
	@Column(name="harvest_notes")
	private String harvest_notes;
	
	@Column(name="email")
	private String email;


	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getHarvest_id() {
		return harvest_id;
	}
	
	public void setHarvest_id(int harvest_id) {
		this.harvest_id = harvest_id;
	}

	public String getSeed_type() {
		return seed_type;
	}

	public void setSeed_type(String seed_type) {
		this.seed_type = seed_type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getHarvest_date() {
		return harvest_date;
	}

	public void setHarvest_date(Date harvest_date) {
		this.harvest_date = harvest_date;
	}
	

	public String getHarvest_notes() {
		return harvest_notes;
	}

	public void setHarvest_notes(String harvest_notes) {
		this.harvest_notes = harvest_notes;
	}

}
