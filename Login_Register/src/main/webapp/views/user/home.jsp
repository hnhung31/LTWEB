<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ĐÂY LÀ TRANG CHỦ CỦA USER
	<form action="<%=request.getContextPath()%>/logout" method="post">
		<input type="submit" value="Đăng Xuất">
</body>
</html>