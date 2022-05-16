package com.solvd.post.dao;

import java.util.List;


import com.solvd.post.dao.models.PackageBox;

public interface IPackagesDAO extends IBaseDAO<PackageBox>{

	List<PackageBox> getAllPackages(long id);
}
