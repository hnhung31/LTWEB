<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="vn.iostar.utils.Constant" %>
<%
    // Đọc cookie và lấy giá trị username
    Cookie[] cookies = request.getCookies();
    String username = "";
	String password ="";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
                username = cookie.getValue();
            }
            if (Constant.COOKIE_REMEMBERP.equals(cookie.getName())) {
                password = cookie.getValue();
                break;
            }
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form action="/Login_Register/login" method="post">
					<h2 class="text-center mb-4">ĐĂNG NHẬP</h2>
					<c:if test="${alert !=null}">
						<h3 class="alert alert-danger text-center">${alert}</h3>
					</c:if>
					<div class="mb-3">
						<label for="username" class="form-label">Tài khoản</label>
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-user"></i></span>
							<input type="text" placeholder="Tài khoản" name="username" class="form-control" value="<%= username %>" required>
						</div>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Mật khẩu</label>
						<div class="input-group">
							<span class="input-group-text"><i class="fa fa-lock"></i></span>
							<input type="password" placeholder="Mật Khẩu" name="password" class="form-control" value="<%= password %>" required> <br>
						</div>
					</div>
					<div >
						<input type="checkbox" name="remember" class="form-control"> Nhớ tôi
						<a href="reset-password.jsp">Quên mật khẩu?</a> 
										
					</div>
					<div >
						<input type="submit" value="Đăng nhập" >
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>