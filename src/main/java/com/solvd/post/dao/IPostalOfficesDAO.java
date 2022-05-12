package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.PostalOffice;

public interface IPostalOfficesDAO extends IBaseDAO<PostalOffice> {

	List<PostalOffice> getIPostalOfficesById(long id);

}
