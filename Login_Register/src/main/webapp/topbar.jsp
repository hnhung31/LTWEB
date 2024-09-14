<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login_Register</title>
</head>
<body >
	<h2>XIN CHÀO!</h2>
	<c:choose>
		<c:when test="${sessionScope.account == null}">
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<a href="${pageContext.request.contextPath }/login.jsp">Đăng nhập</a>
					| 	<a href="${pageContext.request.contextPath }/register.jsp">Đăng ký</a>
				</ul>
			</div>
		</c:when>
	</c:choose>
</body>
</html>