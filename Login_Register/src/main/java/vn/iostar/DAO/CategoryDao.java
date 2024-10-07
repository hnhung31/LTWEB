package vn.iostar.DAO;

import java.util.List;

import vn.iostar.model.CategoryModel;

public interface CategoryDao {
	List<CategoryModel> findAll();
	CategoryModel findById( int id);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete( int id);
	List<CategoryModel> findByCategoryname( String keyword);
	
}
