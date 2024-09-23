package vn.iostar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.services.*;
import vn.iostar.services.Impl.*;
import java.io.IOException;



@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			response.sendRedirect(request.getContextPath() + "/admin");
		return;}
		// Check cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = request.getSession(true);
					session.setAttribute("username", cookie.getValue());
					response.sendRedirect(request.getContextPath() + "/admin");
					return;
				}
			}
		}
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		UserService service = new UserServiceImpl();
		String alertMsg = "";
		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		if (service.checkExistUsername(username)) {
		alertMsg = "Tài khoản đã tồn tại!";
		req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		return;
		}
		boolean isSuccess = service.register(email,username,fullname, password,phone);
		if (isSuccess) {
			//SendMail sm = new SendMail();
			//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Loginto use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
		} 
		else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		}
	}
}
