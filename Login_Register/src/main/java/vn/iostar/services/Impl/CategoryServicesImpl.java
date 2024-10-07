package vn.iostar.services.Impl;

import java.util.List;

import vn.iostar.DAO.CategoryDao;
import vn.iostar.DAO.Impl.CategoryDaoImpl;
import vn.iostar.model.CategoryModel;
import vn.iostar.services.ICategoryServices;

public class CategoryServicesImpl implements ICategoryServices {
	public CategoryDao cateDao =new  CategoryDaoImpl();

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		// TODO Auto-generated method stub
		return cateDao.findById(id);
	}

	@Override
	public void insert(CategoryModel category) {
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(category.getCategoryid());
		if (cate != null) {
			cateDao.update(category);
		}	
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = cateDao.findById(id);
		if (cate != null) {
			cateDao.delete(id);
		}
		
	}

	@Override
	public List<CategoryModel> findByCategoryname(String keyword) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryname(keyword);
	}
	
}
