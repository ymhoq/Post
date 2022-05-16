package com.solvd.post.dao.models;

import java.sql.Date;
import java.util.List;

public class Order {

	private long id;
	private Date createDate;
	private int senderId;
	private int recipientId;
	private Stuff stuff;
	private Payment payment;
	private List<PackageBox> packagesId;

	public Order() {
	}

	public Order(Order order) {
		this.id = order.getId();
		this.createDate = order.getCreateDate();
		this.senderId = order.getSenderId();
		this.recipientId = order.getRecipientId();
		this.stuff = order.getStuff();
		this.payment = order.getPayment();
		this.packagesId = order.getPackagesId();
	}

	public Order(long id, Date createDate, int senderId, int recipientId, Stuff stuff, Payment payment,
			List<PackageBox> packagesId) {
		this.id = id;
		this.createDate = createDate;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.stuff = stuff;
		this.payment = payment;
		this.packagesId = packagesId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public Stuff getStuff() {
		return stuff;
	}

	public void setStuff(Stuff stuff) {
		this.stuff = stuff;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<PackageBox> getPackagesId() {
		return packagesId;
	}

	public void setPackagesId(List<PackageBox> packagesId) {
		this.packagesId = packagesId;
	}

}
