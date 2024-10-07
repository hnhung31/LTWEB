package vn.iostar.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iostar.DAO.CategoryDao;
import vn.iostar.configs.DBConnection;
import vn.iostar.model.CategoryModel;
public class CategoryDaoImpl implements CategoryDao {

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs= null;
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM Categories ";
		List<CategoryModel> list= new ArrayList<>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setActive(rs.getBoolean("active"));
				list.add(category);
			}
			return list;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM Categories Where categoryid = ? ";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setActive(rs.getBoolean("active"));
				return category;
			}
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Categories(categoryname, images, active) VALUES (?,?,?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setBoolean(3, category.isActive());
			ps.executeUpdate();
			conn.close();
		} 
		catch (Exception e) {e.printStackTrace();}
		
	}
	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE categories SET categoryname = ?, images=?, active = ?  WHERE categoryid = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setBoolean(3, category.isActive());
			ps.setInt(4,  category.getCategoryid());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {e.printStackTrace();}
		
	}
	@Override
	public void delete(int id) {
		String sql= "DELETE FROM Categories WHERE categoryid =?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<CategoryModel> findByCategoryname(String keyword) {
		String sql = "SELECT * FROM categories Where categoryname like ? ";
		List<CategoryModel> list= new ArrayList<>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + keyword +"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setActive(rs.getBoolean("active"));
				list.add(category);
			}
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
