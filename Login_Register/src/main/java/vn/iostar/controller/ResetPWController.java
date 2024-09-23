package vn.iostar.controller;

import java.io.IOException;
import vn.iostar.services.*;
import vn.iostar.services.Impl.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reset-password")
public class ResetPWController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("username");
	        String newPassword = request.getParameter("password");
	        String confirmPassword = request.getParameter("confirm_password");
	        UserService service = new UserServiceImpl();
	        if (newPassword.equals(confirmPassword)) {
	            boolean success = service.updatePassword(username, newPassword);
	            if (success) 
	            {
	                request.setAttribute("message", "Mật khẩu đã được cập nhật thành công.");
	                request.getRequestDispatcher("/views/login.jsp").forward(request, response);	                
	            } else {
	                request.setAttribute("error", "Tài khoản không tồn tại.");
	                request.getRequestDispatcher("/reset-password.jsp").forward(request, response);
	            }
	        } else {
	            request.setAttribute("error", "Mật khẩu và xác nhận mật khẩu không khớp.");
	            request.getRequestDispatcher("views/reset-password.jsp").forward(request, response);
	        }

	    }
}


