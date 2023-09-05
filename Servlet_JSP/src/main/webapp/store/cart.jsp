<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*,com.store.product.Model.ProductVO,javax.servlet.http.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>商品圖片</th>
				<th>名稱</th>
				<th>描述</th>
				<th>價格</th>
				<th>數量</th>
				<th>刪除<th>
			</tr>
		</thead>
		<tbody>
	<!-- 		第一步 取得購物車陣列 -->
			<c:forEach var="productVO" items="${sessionScope.shopCart}">
			 	<tr>
					<td><img src="${productVO.proPic}"></td>
					<td>${productVO.proName}</td>
					<td>${productVO.proDescript}</td>
					<td>${productVO.proPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>