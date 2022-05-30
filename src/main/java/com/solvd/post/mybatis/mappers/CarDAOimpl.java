package com.solvd.post.mybatis.mappers;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.post.mybatis.datasource.DataSource;
import com.solvd.post.mybatis.po.Car;

public class CarDAOimpl extends DataSource implements ICarDAO {

	DataSource ds = new DataSource();

	@Override
	public void createEntity(Car car) {
		SqlSession sqlSession = ds.getSqlSession();

		// default add

		car.setModel("mewModel");
		car.setYear(1995);
		car.setCapasity(20);

		sqlSession.insert("CarMapper.insertCar", car);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Car getEntity(long id) throws SQLException {
		SqlSession sqlSession = ds.getSqlSession();
		Car car = sqlSession.selectOne("CarMapper.findCarById", id);
		sqlSession.commit();
		sqlSession.close();
		return car;
	}

	@Override
	public void updateEntity(Car car) {
		SqlSession sqlSession = ds.getSqlSession();
		car.setId(2);
		car.setModel("mgdfgs");

		sqlSession.update("CarMapper.updateCar", car);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void removeEntity(long id) {
		SqlSession sqlSession = ds.getSqlSession();
		sqlSession.delete("CarMapper.deleteCar", id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<Car> multiSearch() throws Exception {
		SqlSession sqlSession = ds.getSqlSession();
		List<Car> resultList = sqlSession.selectList("CarMapper.multiSearch");

		sqlSession.commit();
		sqlSession.close();
		return resultList;
	}

}
