package com.solvd.post.dao.models;

public class Category {

	public long id;
	public String name;
	public int size;
	public int weight;

	public Category() {
	}

	public Category(String name, int year, int capacity, long id) {
		this.name = name;
		this.size = year;
		this.weight = capacity;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int year) {
		this.size = year;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int capacity) {
		this.weight = capacity;
	}

}
