package com.solvd.post.mybatis.mappers;

import java.util.List;

import com.solvd.post.mybatis.po.Country;

public interface ICountryDAO extends IBaseDAO<Country>{
	public List<Country> multiSearch() throws Exception;
}
