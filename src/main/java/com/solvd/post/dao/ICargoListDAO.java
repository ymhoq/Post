package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.CargoList;

public interface ICargoListDAO extends IBaseDAO<CargoList> {

	List<CargoList> getCargoListById(int id);
}
