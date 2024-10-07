<%@page import="vn.iostar.services.Impl.CategoryServicesImpl"%>
<%@page import="vn.iostar.services.ICategoryServices"%>
<%@page import="vn.iostar.model.CategoryModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%
ICategoryServices service = new CategoryServicesImpl();
List<CategoryModel> list = service.findAll();
request.setAttribute("listcate", list);
%>
<jsp:forward page="/views/topbar.jsp" />
<!-- <c:redirect url="/views/topbar.jsp" /> -->