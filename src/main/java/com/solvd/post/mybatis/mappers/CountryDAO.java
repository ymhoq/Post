package com.solvd.post.mybatis.mappers;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.post.mybatis.datasource.DataSource;
import com.solvd.post.mybatis.po.Car;
import com.solvd.post.mybatis.po.Country;
import com.solvd.post.mybatis.po.Payment;

public class CountryDAO extends DataSource implements ICountryDAO{

	DataSource ds = new DataSource();
	
	@Override
	public void createEntity(Country country) {
		SqlSession sqlSession = ds.getSqlSession();

		sqlSession.insert("CountryMapper.insertCountry", country);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Country getEntity(long id) throws SQLException {
		SqlSession sqlSession = ds.getSqlSession();
		Country country = sqlSession.selectOne("CountryMapper.findCountryById", id);
		sqlSession.commit();
		sqlSession.close();
		return country;
	}

	@Override
	public void updateEntity(Country country) {
		SqlSession sqlSession = ds.getSqlSession();
	

		sqlSession.update("CountryMapper.updateCountry", country);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void removeEntity(long id) {
		SqlSession sqlSession = ds.getSqlSession();
		sqlSession.delete("CountryMapper.deleteCountry", id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<Country> multiSearch() throws Exception {
		SqlSession sqlSession = ds.getSqlSession();
		List<Country> resultList = sqlSession.selectList("CountryMapper.multiSearch");

		sqlSession.commit();
		sqlSession.close();
		return resultList;
	}

}
