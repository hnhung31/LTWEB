package vn.iostar.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.model.CategoryModel;
import vn.iostar.services.ICategoryServices;
import vn.iostar.services.Impl.CategoryServicesImpl;
import static vn.iostar.utils.Constant.*;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/categories","/admin/category/insert","/admin/category/update"})
public class CategoryController extends HttpServlet {

	public ICategoryServices cateService = new CategoryServicesImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("insert")) {
			req.getRequestDispatcher("/views/admin/category-insert.jsp").forward(req, resp);
		}else if(url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			CategoryModel category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-update.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		
		if(url.contains("insert")) {
			CategoryModel category = new CategoryModel();
			String categoryname = req.getParameter("categoryname");
			boolean active = req.getParameter("active").equals("1");
			category.setCategoryname(categoryname);
			category.setActive(active);
			
			String fname="";
			String uploadPath=UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					part.write(uploadPath + "/" + fname);
					category.setImages(fname);			
				}else {
					category.setImages("avatar.png");					
				}
			} catch (Exception e){
				e.printStackTrace();				
			}			
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}else if(url.contains("/admin/category/update")){
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			String categoryname = req.getParameter("categoryname");
			boolean active = req.getParameter("active").equals("1");
			
			CategoryModel category = new CategoryModel();
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setActive(active);
			

			CategoryModel cateold = cateService.findById(categoryid);
			String fileold = cateold.getImages();

			String fname="";
			String uploadPath=UPLOAD_DIRECTORY;
			File uploadDir = new File(uploadPath);
			if (uploadDir.exists()) {
				uploadDir.mkdir();
			}
			try {
				Part part = req.getPart("images");
				if (part.getSize() > 0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;

					part.write(uploadPath + "/" + fname);

					category.setImages(fname);			
				}else {
					category.setImages(fileold);					
				}
			} catch (Exception e){
				e.printStackTrace();				
			}			
			
			cateService.update(category);
			resp.sendRedirect(req.getContextPath()+"/admin/categories");
			
		}
	}

	
}
