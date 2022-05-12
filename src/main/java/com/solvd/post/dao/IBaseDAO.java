package com.solvd.post.dao;

import java.sql.SQLException;

public interface IBaseDAO <T>{

	void createEntity(T data);
	T getEntity(long id) throws SQLException;
	void updateEntity(T data);
	void removeEntity(long id);
}
