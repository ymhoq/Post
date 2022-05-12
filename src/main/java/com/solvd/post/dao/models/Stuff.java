package com.solvd.post.dao.models;

public class Stuff {

	private long id;
	private String firstName;
	private String lastName;
	private String position;
	private int phoneNumber;
	private long postalOfficesId;

	public Stuff() {}
	
	public Stuff(long id, String firstName, String lastName, String position, int phoneNumber, long postalOfficesId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.phoneNumber = phoneNumber;
		this.postalOfficesId = postalOfficesId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getPostalOfficesId() {
		return postalOfficesId;
	}

	public void setPostalOfficesId(long postalOfficesId) {
		this.postalOfficesId = postalOfficesId;
	}

}
