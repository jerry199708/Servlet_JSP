<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.store.member.DAO.*"%>
<%@ page import="com.store.member.Model.*" %>
<%@ page import="com.store.member.Service.*" %>
<%

	MemberService svc = new MemberService();
	List<MemberVO>list = svc.getAll();
// 	隱含物件
// 	pageContext、request、session、application
	pageContext.setAttribute("memListData", list);

	Map<String, String> ErrorMsg = (Map<String, String>)request.getAttribute("ErrorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/headers.css">
</head>
<body>
<!-- =======================header======================= -->
<header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="#" class="nav-link px-2 link-secondary">Overview</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">Inventory</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">Customers</a></li>
          <li><a href="#" class="nav-link px-2 link-dark">Products</a></li>
        </ul>

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control" placeholder="Search..." aria-label="Search">
        </form>

        <div class="dropdown text-end">
          <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>
          <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
            <li><a class="dropdown-item" href="#">New project...</a></li>
            <li><a class="dropdown-item" href="#">Settings</a></li>
            <li><a class="dropdown-item" href="#">Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Sign out</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
<!-- =======================header======================= -->

	<a href="listAllMem.jsp">all Mem</a></br>
	<a href="listAllMem.jsp">all Mem沒斜線</a></br>
	<a href="/Servlet_JSP/listAllMem.jsp">all Mem 有斜線</a></br>
	<!-- port下的位置 -->
	<!-- <a href="/">有斜線</a></br> -->
	<!-- 專案下的位置 -->
	<!-- <a href="">沒斜線</a></br> -->
	
	
	<li>
		<FORM action="id" method="post">
			<font style="color:red">${ErrorMsg.memberId}</font>
			<p>
				輸入會員編號 : 
				<input type="text" name="memId">
			</p>
			<p>
				<button name="btnMemId">查詢</button>
			</p>
		</FORM>
	</li>
	
	
	Method 1:
	<li>
		<FORM action="id" method="post">
		請選擇會員編號 : 
		<select name="memId">
			<c:forEach var="memVO" items="${memListData}">
			<option value="${memVO.id}">${memVO.id}</option>
			</c:forEach>
		</select> 
		<button type="submit" name="btnMemId">查詢</button>
		</FORM>
	</li> 
	
	
	Method 2:
	<li> 
		<FORM action="id" method="post">
		請選擇會員編號 : 
	<jsp:useBean id="MemSVC" scope="page" class="com.store.member.Service.MemberService"/>
		<select name="memId">
			<c:forEach var="memVO2" items="${MemSVC.all}">
			<option value="${memVO2.id}">${memVO2.id}</option>
			</c:forEach>
		</select>
		<button type="submit" name="btnMemId">查詢</button>
		</FORM> 
	</li>
	
	
	<li>
		<FORM action="name" method="post">
		請選擇會員名稱 : 
		<select name="memName">
		<c:forEach var="memVO" items="${memListData}">
			<option value="${memVO.name }">${memVO.name}</option>
		</c:forEach>
		</select>
		<button type="submit" name="btnMemName">查詢</button>
		</FORM>
	</li>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>