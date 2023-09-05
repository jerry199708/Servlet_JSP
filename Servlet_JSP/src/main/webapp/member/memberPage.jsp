<%@page import="com.store.member.DAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "java.util.*"%>
<%@ page import= "com.store.member.*"%>
<%@ page import="com.store.member.Model.*"%>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> memLists = dao.getAll();
	pageContext.setAttribute("memLists", memLists);
	Integer pageCount = (Integer)request.getAttribute("pageCount");
	if(pageCount==null){
		pageCount = 1;
	}
	List<MemberVO> pageResult =(List)request.getAttribute("pageResult");
%>
<!DOCTYPE html>
<html>
<head>
<title>分頁功能表格</title>
<!-- 引入 Bootstrap CSS 檔案 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container mt-4">
		<h2>分頁功能表格</h2>

		<!-- 分頁設定 -->
		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="itemsPerPage">每頁顯示幾筆:</label> <select
					class="form-control" id="itemsPage" onchange="updateTable()">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
		</div>

		<!-- 表格 -->
		<table class="table" id="pagingTable">
			<thead>
				<tr>
					<th>信箱</th>
					<th>密碼</th>
					<th>名稱</th>
					<th>電話</th>
					<th>編號</th>
				</tr>
			</thead>
			<tbody>
				<!-- 這裡只示範一行，你可以根據需求添加更多的表格內容 -->
				<c:forEach var="MemVO" items="${memLists}">
				<tr>
					<td>${MemVO.email}</td>
					<td>${MemVO.pwd}</td>
					<td>${MemVO.name}</td>
					<td>${MemVO.phone}</td>
					<td>${MemVO.id}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 分頁按鈕 -->
		<ul class="pagination" id="pagination">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<% for(int i = 0; i < pageCount; i++){%>
				<li class="page-item"><a class="page-link" href="#"><%=i+1 %></a></li>
			<% } %>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
			<!-- Pagination 由 JavaScript 生成 -->
			<!--送出按鈕 -->
			<form action="page" method="get">
				<button type = "submit" id = "search">查詢</button>
			</form>
		</ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
// 		$('#search').on('click',function(){
			
// 		});
	</script>
</body>
</html>
