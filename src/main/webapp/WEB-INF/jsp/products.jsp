<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>产品列表</title>
</head>
<body>
	<h1>产品列表</h1>
	<table>
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>价格</th>
		</tr>
		<c:forEach items="${products }" var="p">
			<tr>
				<td>${p.id }</td>
				<td>${p.name }</td>
				<td>${p.price }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>