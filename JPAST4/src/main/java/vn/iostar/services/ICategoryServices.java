package vn.iostar.services;

import java.util.List;

import vn.iostar.entity.Category;

public interface ICategoryServices {
	void insert(Category category);


	 int count();


	 List<Category> findAll(int page, int pagesize);


	 List<Category> searchByName(String catname);


	 List<Category> findAll();


	 Category findById(int cateid);


	 void delete(int cateid) throws Exception;


	 void update(Category category);


	 Category findByCategoryname(String name);


}
