package com.solvd.post.dao;

import java.util.List;

import com.solvd.post.dao.models.Order;

public interface IOrdersDAO extends IBaseDAO<Order>{

	List<Order> getAllOrdersByCustomer(long id);
}
