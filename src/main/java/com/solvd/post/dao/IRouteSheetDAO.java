package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.RouteSheet;

public interface IRouteSheetDAO extends IBaseDAO<RouteSheet> {

	List<RouteSheet> getRouteSheetById(long id);

}
