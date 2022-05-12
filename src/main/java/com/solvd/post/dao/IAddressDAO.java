package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.Address;

public interface IAddressDAO extends IBaseDAO<Address> {

	List<Address> getAllAddress();
   
}
