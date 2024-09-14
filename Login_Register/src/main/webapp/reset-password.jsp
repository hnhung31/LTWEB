<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Đặt lại mật khẩu</h2>
        <form action="reset-password" method="post">
            <div class="input-group">
			<label>Tên người dùng</label><br />
			<input type="text" name="username" > <br />
			
			<label>Mật khẩu mới</label><br />
			<input type="text" name="password" > <br />
				
			<label>Nhập lại mật khẩu</label><br />
			<input type="text" name="confirm_password" > <br /><br />
			
			<input type="submit" value="Khôi phục mật khẩu">
			</div>
        </form>
</body>
</html>