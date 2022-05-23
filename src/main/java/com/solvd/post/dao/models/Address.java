package com.solvd.post.dao.models;

public class Address {

	private long id;
	private String address;
	private String district;
	private int postalCode;
	private City city;

	public Address() {
	}

	public Address(City city) {
		this.city = city;
	}
	
	public Address(long id, String address, String district, int postalCode, City city) {
		this.id = id;
		this.address = address;
		this.district = district;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int code) {
		this.postalCode = code;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", district=" + district + ", postalCode=" + postalCode
				+ ", city=" + city.toString() + "]\n";
	}

}
