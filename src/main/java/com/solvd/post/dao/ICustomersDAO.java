
package com.solvd.post.dao;

import java.util.List;

import com.solvd.post.dao.models.Customer;

public interface ICustomersDAO extends IBaseDAO<Customer> {

	List<Customer> getAllCustomers(long id);
}
