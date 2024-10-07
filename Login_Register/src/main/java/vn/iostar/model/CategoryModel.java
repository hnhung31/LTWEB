package vn.iostar.model;

import java.io.Serializable;

public class CategoryModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryid;
	private String categoryname;
	private String images;
	private boolean active;
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public CategoryModel(int categoryid, String categoryname, String images) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.images = images;
	}
	public CategoryModel() {
		super();
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categoryname=" + categoryname + ", images=" + images
				+ "]";
	}
}
