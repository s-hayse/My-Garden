package com.mygarden.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="plant")
public class Plant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cultivation_id")
	private int cultivation_id;
	
	@Column(name="seed_type")
	private String seed_type;
	
	@Column(name="plant_date")
	private Date plant_date;
	
	@Column(name="harvest_date")
	private Date harvest_date;
	
	@Column(name="cultivation_notes")
	private String cultivation_notes;
	
	@Column(name="email")
	private String email; 
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="email")
//	private Gardener gardener;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="seed_type")
//	private Seed seed;
	
//	public Seed getSeed() {
//		return seed;
//	}
//	
//	public void setSeed(Seed seed) {
//		this.seed = seed;
//	}
	
//	public Gardener getGardener() {
//		return gardener;
//	}
//	
//	public void setGardener(Gardener gardener) {
//		this.gardener = gardener;
//	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getcultivation_id() {
		return cultivation_id;
	}

	public void setcultivation_id(int cultivation_id) {
		this.cultivation_id = cultivation_id;
	}

	public String getseed_type() {
		return seed_type;
	}

	public void setseed_type(String seed_type) {
		this.seed_type = seed_type;
	}

	public Date getplant_date() {
		return plant_date;
	}

	public void setplant_date(Date plant_date) {
		this.plant_date = plant_date;
	}

	public Date getharvest_date() {
		return harvest_date;
	}

	public void setharvest_date(Date harvest_date) {
		this.harvest_date = harvest_date;
	}

	public String getcultivation_notes() {
		return cultivation_notes;
	}

	public void setcultivation_notes(String cultivation_notes) {
		this.cultivation_notes = cultivation_notes;
	}

	
}
