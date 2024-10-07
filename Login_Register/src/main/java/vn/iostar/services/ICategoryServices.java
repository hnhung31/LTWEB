package vn.iostar.services;

import java.util.List;

import vn.iostar.model.CategoryModel;

public interface ICategoryServices {
	List<CategoryModel> findAll();

	CategoryModel findById(int id);

	void insert(CategoryModel category);

	void update(CategoryModel category);

	void delete(int id);

	List<CategoryModel> findByCategoryname(String keyword);
}
