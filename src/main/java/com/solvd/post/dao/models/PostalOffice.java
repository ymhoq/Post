package com.solvd.post.dao.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "PostalOffice")
public class PostalOffice implements Serializable{

	
	private static final long serialVersionUID = -3597261062056227904L;
	private long id;
	private int phone;
	private String type;
	private Address address = new Address();

	public PostalOffice() {}
	
	public PostalOffice(long id, int phone, String type) {
		this.id = id;
		this.phone = phone;
		this.type = type;
	}
	
	public PostalOffice(long id, int phone, String type, Address address) {
		this.id = id;
		this.phone = phone;
		this.type = type;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PostalOffice [id=" + id + ", phone=" + phone + ", type=" + type + ", address=" + address + "]";
	}
	
}
