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
				<th>�ӫ~�Ϥ�</th>
				<th>�W��</th>
				<th>�y�z</th>
				<th>����</th>
				<th>�ƶq</th>
				<th>�R��<th>
			</tr>
		</thead>
		<tbody>
	<!-- 		�Ĥ@�B ���o�ʪ����}�C -->
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