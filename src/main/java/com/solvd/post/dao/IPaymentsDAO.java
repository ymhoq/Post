package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.Payment;

public interface IPaymentsDAO extends IBaseDAO<Payment> {

	List<Payment> getAllPayments(long id);

}
