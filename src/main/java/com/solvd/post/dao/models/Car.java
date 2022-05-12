package com.solvd.post.dao.models;

public class Car {
	private long id;
	private String model;
	private int year;
	private int capasity;

	public Car() {}

	public Car(long id, String model, int year, int capasity) {
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
