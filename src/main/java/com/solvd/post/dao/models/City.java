package com.solvd.post.dao.models;

public class City {
	private long id;
	private String cityName;
	private Country country;

	public City() {
		country = new Country();
	}
	
	

	public City(long id, String cityName, Country country) {
		this.id = id;
		this.cityName = cityName;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountryId(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", country=" + country + "]";
	}
}
