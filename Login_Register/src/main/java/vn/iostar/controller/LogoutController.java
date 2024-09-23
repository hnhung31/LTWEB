package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.utils.Constant;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        session.removeAttribute("account");

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				break;

			}
		}

		request.getRequestDispatcher("/views/topbar.jsp").forward(request, response);
    }
}
