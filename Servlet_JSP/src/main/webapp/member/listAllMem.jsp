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
	<a href="select_page.jsp"><img src="images/back1.gif">�^����</a>
	<table class="container">
		<tr>
			<th>�|���s��</th>
			<th>�W��</th>
			<th>�H�c</th>
			<th>�K�X</th>
			<th>�p���覡</th>
			<th>�Ϥ�</th>
			<th>�s��</th>
			<th>�R��</th>
		</tr>
		<c:forEach var="memVO" items="${memListData}">
		<tr>
			<td>${memVO.id}</td>
			<td>${memVO.name}</td>
			<td>${memVO.email}</td>
			<td>${memVO.pwd}</td>
			<td>${memVO.phone}</td>
			<td>${memVO.pic}</td>
			<td><button class="btn btn-primary" name="memberEdit">�s��</button></td>
			<td><button class="btn btn-primary" name="memberDel">�R��</button></td>
		</tr>
		</c:forEach>
	</table>
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>