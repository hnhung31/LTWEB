<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Login_Register/register" method="post">
	<h2>Tạo tài khoản mới</h2>
	<c:if test="${alert != null}">
		<h3 class="alert alertdanger">${alert}</h3>
	</c:if>
	<section>
		<label class="input login-input">
			<div class="input-group">
			<label>Email</label><br />
			<input type="text" name="email" > <br />
			
			<label>Tài khoản</label><br />
			<input type="text" name="username" > <br />
			
			<label>Họ và tên</label><br />
			<input type="text" name="fullname" > <br />
			
			<label>Mật khẩu</label><br />
			<input type="text" name="password" > <br />
			

			<label>Sđt</label><br />
			<input type="text" name="phone" > <br /> <br />
				
			<input type="submit" value="Đăng kí">
			</div>
		</label>
	</section>
	</form>
</body>
</html>