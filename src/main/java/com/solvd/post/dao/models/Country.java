package com.solvd.post.dao.models;

import java.util.List;

public class Country {

	private long id;
	private String name;
	private List<String> citys;

	public Country() {
	}
	
	

	public Country(long id, String name, List<String> citys) {
		this.id = id;
		this.name = name;
		this.citys = citys;

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

	public List<String> getCitys() {
		return citys;
	}

	public void setCitys(List<String> citys) {
		this.citys = citys;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name +  "]";
	}

}
