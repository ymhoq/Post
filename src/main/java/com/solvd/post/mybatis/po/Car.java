package com.solvd.post.mybatis.po;

import java.io.Serializable;

public class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6306064799242753774L;
	private int id;
	private String model;
	private int year;
	private int capasity;

	public Car() {
	}

	public Car(int id, String model, int year, int capasity) {
		this.id = id;
		this.model = model;
		this.year = year;
		this.capasity = capasity;
	}

	public int getCapasity() {
		return capasity;
	}

	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year + ", capasity=" + capasity + "]";
	}
	
}
