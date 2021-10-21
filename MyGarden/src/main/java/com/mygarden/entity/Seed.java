package com.mygarden.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seed")
public class Seed {
	
	@Id
	@Column(name="seed_type")
	private String seed_type;  //autofill db values
	
	@Column(name="sun_req")
	private String sun_req; //drop down selection: full sun; partial sun; shaded; etc.
	
	@Column(name="days_to_germ")
	private int days_to_germ;
	
	@Column(name="days_to_harvest")
	private int days_to_harvest;
	
	@Column(name="row_spacing")
	private double row_spacing;
	
	@Column(name="plant_spacing")
	private double plant_spacing;
	
	@Column(name="plant_depth")
	private double plant_depth;

	public String getSeed_type() {
		return seed_type;
	}

	public void setSeed_type(String seed_type) {
		this.seed_type = seed_type;
	}

	public String getSun_req() {
		return sun_req;
	}

	public void setSun_req(String sun_req) {
		this.sun_req = sun_req;
	}

	public int getDays_to_germ() {
		return days_to_germ;
	}

	public void setDays_to_germ(int days_to_germ) {
		this.days_to_germ = days_to_germ;
	}

	public int getDays_to_harvest() {
		return days_to_harvest;
	}

	public void setDays_to_harvest(int days_to_harvest) {
		this.days_to_harvest = days_to_harvest;
	}

	public double getRow_spacing() {
		return row_spacing;
	}

	public void setRow_spacing(double row_spacing) {
		this.row_spacing = row_spacing;
	}

	public double getPlant_spacing() {
		return plant_spacing;
	}

	public void setPlant_spacing(double plant_spacing) {
		this.plant_spacing = plant_spacing;
	}

	public double getPlant_depth() {
		return plant_depth;
	}

	public void setPlant_depth(double plant_depth) {
		this.plant_depth = plant_depth;
	}

}
