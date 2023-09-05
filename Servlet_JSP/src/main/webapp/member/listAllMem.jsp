<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>
<%@ page import="com.store.member.Model.*"%>
<%@ page import="com.store.member.DAO.*" %>
<%@ page import="com.store.member.Service.*" %>
<%
	MemberService svc = new MemberService();
	List<MemberVO>list = svc.getAll();
	pageContext.setAttribute("memListData", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/listmem.css">
</head>
<body>
	<a href="select_page.jsp"><img src="images/back1.gif">回首頁</a>
	<table class="container">
		<tr>
			<th>會員編號</th>
			<th>名稱</th>
			<th>信箱</th>
			<th>密碼</th>
			<th>聯絡方式</th>
			<th>圖片</th>
			<th>編輯</th>
			<th>刪除</th>
		</tr>
		<c:forEach var="memVO" items="${memListData}">
		<tr>
			<td>${memVO.id}</td>
			<td>${memVO.name}</td>
			<td>${memVO.email}</td>
			<td>${memVO.pwd}</td>
			<td>${memVO.phone}</td>
			<td>${memVO.pic}</td>
			<td><button class="btn btn-primary" name="memberEdit">編輯</button></td>
			<td><button class="btn btn-primary" name="memberDel">刪除</button></td>
		</tr>
		</c:forEach>
	</table>
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>