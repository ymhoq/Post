package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.Car;

public interface ICarsDAO extends IBaseDAO<Car>{

	List<Car> getAllCars(long id);
	
}
