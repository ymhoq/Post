package com.solvd.post.dao.models;

import java.sql.Date;

public class Payment {

	private long id;
	private int amount;
	private Date date;

	public Payment() {
	}

	public Payment(long id, int amount, Date date) {
		this.id = id;
		this.amount = amount;
		this.date = date;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
