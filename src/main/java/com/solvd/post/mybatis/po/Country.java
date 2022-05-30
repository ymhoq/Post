package com.solvd.post.mybatis.po;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3064110116094143051L;
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
		return "Country [id=" + id + ", name=" + name +  "]\n";
	}

}
