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
<title>�����\����</title>
<!-- �ޤJ Bootstrap CSS �ɮ� -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

	<div class="container mt-4">
		<h2>�����\����</h2>

		<!-- �����]�w -->
		<div class="form-row">
			<div class="form-group col-md-2">
				<label for="itemsPerPage">�C����ܴX��:</label> <select
					class="form-control" id="itemsPage" onchange="updateTable()">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
			</div>
		</div>

		<!-- ��� -->
		<table class="table" id="pagingTable">
			<thead>
				<tr>
					<th>�H�c</th>
					<th>�K�X</th>
					<th>�W��</th>
					<th>�q��</th>
					<th>�s��</th>
				</tr>
			</thead>
			<tbody>
				<!-- �o�̥u�ܽd�@��A�A�i�H�ھڻݨD�K�[��h����椺�e -->
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

		<!-- �������s -->
		<ul class="pagination" id="pagination">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			<% for(int i = 0; i < pageCount; i++){%>
				<li class="page-item"><a class="page-link" href="#"><%=i+1 %></a></li>
			<% } %>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
			<!-- Pagination �� JavaScript �ͦ� -->
			<!--�e�X���s -->
			<form action="page" method="get">
				<button type = "submit" id = "search">�d��</button>
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
