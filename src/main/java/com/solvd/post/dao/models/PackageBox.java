package com.solvd.post.dao.models;

public class PackageBox {

	private long id;
	private String options;
	private int insuranceAmount;
	private String status;
	private Category category;
	private Order order;

	public PackageBox() {
	}

	public PackageBox(long id) {
		this.id = id;
	}

	public PackageBox(long id, String options, int insuranceAmount, String status, Category category, Order order) {
		this.id = id;
		this.options = options;
		this.insuranceAmount = insuranceAmount;
		this.status = status;
		this.category = category;
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public int getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(int insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
