package com.solvd.post.mybatis.mappers;

import java.util.List;

import com.solvd.post.mybatis.po.Payment;


public interface IPaymentDAO extends IBaseDAO<Payment>{
	public List<Payment> multiSearch() throws Exception;
}
