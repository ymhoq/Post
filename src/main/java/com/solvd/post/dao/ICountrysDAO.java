package com.solvd.post.dao;

import java.util.List;

import com.solvd.post.dao.models.Country;

public interface ICountrysDAO extends IBaseDAO<Country>{
 
	List<Country> getAllCountryess(int id);
	   	
}
