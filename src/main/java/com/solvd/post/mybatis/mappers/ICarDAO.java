package com.solvd.post.mybatis.mappers;

import java.util.List;

import com.solvd.post.mybatis.po.Car;

public interface ICarDAO extends IBaseDAO<Car>{
	public List<Car> multiSearch() throws Exception;
}
