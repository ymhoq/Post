package com.solvd.post.mybatis.mappers;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.post.mybatis.datasource.DataSource;
import com.solvd.post.mybatis.po.Car;
import com.solvd.post.mybatis.po.Payment;

public class PaymentDAO extends DataSource implements IPaymentDAO {

	DataSource ds = new DataSource();

	@Override
	public void createEntity(Payment payment) {
		SqlSession sqlSession = ds.getSqlSession();

		sqlSession.insert("PaymentMapper.insertPayment", payment);
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public Payment getEntity(long id) throws SQLException {
		SqlSession sqlSession = ds.getSqlSession();
		Payment payment = sqlSession.selectOne("CarMapper.findCarById", id);
		sqlSession.commit();
		sqlSession.close();
		return payment;
	}

	@Override
	public void updateEntity(Payment payment) {
		SqlSession sqlSession = ds.getSqlSession();

		sqlSession.update("PaymentMapper.updatePayment", payment);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void removeEntity(long id) {
		SqlSession sqlSession = ds.getSqlSession();
		sqlSession.delete("PaymentMapper.deletePayment", id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<Payment> multiSearch() throws Exception {
		SqlSession sqlSession = ds.getSqlSession();
		List<Payment> resultList = sqlSession.selectList("PaymentMapper.multiSearch");

		sqlSession.commit();
		sqlSession.close();
		return resultList;
	}

}
