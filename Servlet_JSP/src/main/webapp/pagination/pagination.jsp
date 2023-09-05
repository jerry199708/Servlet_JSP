<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.store.member.Model.MemberVO,java.util.*,com.store.member.Service.MemberService" %>
<%
	MemberService sv = new MemberService();
	List<MemberVO> lists = sv.getAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<!-- Add auto-refresh meta tag -->
<!-- <meta http-equiv="refresh" content="30" /> -->
<title>Bootstrap Form with Pagination</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></head>
<body>
	<table class="table">
  		<thead class="thead-dark">
		    <tr>
		      <th scope="col">Email</th>
		      <th scope="col">Pwd</th>
		      <th scope="col">Name</th>
		    </tr>
  		</thead>
  		<tbody>
			<%List<MemberVO> pageLists=(List<MemberVO>)request.getAttribute("pageLists"); %>
  			<%if(pageLists==null || pageLists.isEmpty()){ %>
		  	<div class="mt-4">
				<nav aria-label="Page navigation">
					<ul class="pagination">	
				  		<% for(int i = 0; i<lists.size(); i++){%>
						    <tr>
						      <td><%=lists.get(i).getEmail() %></td>
						      <td><%=lists.get(i).getPwd() %></td>
						      <td><%=lists.get(i).getName() %></td>
						    </tr>
						    <form action="page" method="get">
								<button class="page-item" type="submit"><%=i+1 %></button>
								<input type="hidden" name="currentPage" value="<%=i+1 %>">
							</form>
						<%} %>
					</ul>
				</nav>
			</div>
			<%}else{ %>
			<div class="mt-4">
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<%for(int i = 0 ;i<pageLists.size(); i++){%>
							<tr>
						      <td><%=pageLists.get(i).getEmail() %></td>
						      <td><%=pageLists.get(i).getPwd() %></td>
						      <td><%=lists.get(i).getName() %></td>
						    </tr>		
						    <form action="page" method="post">
								<button class="page-item" type="submit"><%=i+1 %></button>
								<input type="hidden" name="currentPage" value="<%=i+1 %>">
							</form>
						<%} %>
					<%} %>
					</ul>
				</nav>
			</div>
  		</tbody>
	</table>
			
<!-- 分頁 -->
<!-- 			<div class="mt-4"> -->
<!-- 				<nav aria-label="Page navigation"> -->
<!-- 					<ul class="pagination"> -->
<%-- 							<%if(pageLists==null || pageLists.isEmpty()){ %> --%>
<%-- 								<%for(int i = 0 ;i<lists.size(); i++){ %> --%>
<!-- 									<form action="page" method="get"> -->
<%-- 										<button class="page-item" type="submit"><%=i+1 %></button> --%>
<%-- 										<input type="hidden" name="currentPage" value="<%=i %>"> --%>
<!-- 									</form> -->
<%-- 								<%} %> --%>
<%-- 							<%}else{%> --%>
<%-- 									<%for(int i = 0 ;i<pageLists.size(); i++){ %> --%>
<!-- 									<form action="page" method="get"> -->
<%-- 										<button class="page-item" type="submit"><%=i+1 %></button> --%>
<%-- 										<input type="hidden" name="currentPage" value="<%=i %>"> --%>
<!-- 									</form> -->
<%-- 									<%} %> --%>
<%-- 							<%} %> --%>
<!-- 					</ul> -->
<!-- 				</nav> -->
<!-- 			</div> -->
<!-- 	</div> -->
</body>
</html>