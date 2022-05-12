package com.solvd.post.dao;

import java.util.List;

import com.solvd.post.dao.models.City;

public interface ICityDAO extends IBaseDAO<City>{

	List<City> getCitysById(long id);
	
}
