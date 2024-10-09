<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Trang chủ của ADMIN </h1>
	<form action="<%=request.getContextPath()%>/logout" method="post">
    <input type="submit" value="Đăng Xuất">
</form>

</body>
</html>