package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.PostalOffice;
import com.solvd.post.dao.models.Stuff;

public interface IStuffsDAO extends IBaseDAO<Stuff> {

	List<Stuff> getAllStuffs();
	
	List<Stuff> getAllStuffsByPostalOffice(long id);
	
}
