package com.solvd.post.dao;

import java.util.List;

import com.solvd.post.dao.models.Category;

public interface ICategorysDAO extends IBaseDAO<Category> {

	List<Category> getCategoryById(int id);
}
