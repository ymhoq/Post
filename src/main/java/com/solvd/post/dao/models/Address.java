package com.solvd.post.dao.models;

public class Address {

	private long id;
	private String address;
	private String district;
	private int postalCode;
	private City city_id;

	public Address() {
		city_id = new City();
	}

	public Address(long id, String address, String district, int postalCode, City city_id) {
		this.id = id;
		this.address = address;
		this.district = district;
		this.postalCode = postalCode;
		this.city_id = city_id;
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

	public City getCity_id() {
		return city_id;
	}

	public void setCity_id(City city_id) {
		this.city_id = city_id;
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
				+ ", city_id=" + city_id.toString() + "]";
	}

}
