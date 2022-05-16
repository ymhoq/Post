package com.solvd.post.dao.service;

import java.sql.SQLException;

import com.solvd.post.dao.jdbcMYSQLimpl.OrderDAO;
import com.solvd.post.dao.jdbcMYSQLimpl.PackageDAO;
import com.solvd.post.dao.jdbcMYSQLimpl.PaymentDAO;
import com.solvd.post.dao.jdbcMYSQLimpl.StuffDAO;
import com.solvd.post.dao.models.Order;

public class OrderService {

	private Order order = new Order();

	public OrderService() {
	}

	public OrderService(Order order) {

		this.order = order;
	}

	public Order getOrder(long id) throws SQLException {

		OrderDAO orderDAO = new OrderDAO();
		Order order1 = new Order(orderDAO.getEntity(id));

		StuffDAO stuffDAO = new StuffDAO();
		order1.setStuff(stuffDAO.getEntity(order1.getStuff().getId()));

		// PaymentDAO paymentDAO = new PaymentDAO();
		// paymentDAO.getEntity(orderDAO.getEntity(id).getPayment().getId());

		PackageDAO packagesDAO = new PackageDAO();
		order.setPackagesId(packagesDAO.getAllPackages(orderDAO.getEntity(id).getId()));
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
