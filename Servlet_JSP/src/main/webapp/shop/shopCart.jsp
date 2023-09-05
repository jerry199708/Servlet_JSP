<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="shopcart.*" %>
<%@ page import="java.util.*" %>

<% ShopCart shopCart = (ShopCart)session.getAttribute("shopCart");
	Map<String,Product>proMap = shopCart.getProMap();
	Set<String>keys = proMap.keySet();
	Iterator<String> it = keys.iterator();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=request.getContextPath()+"/shop/shopTable.jsp" %>">�^�ӫ�</a>
	<table>
		<th>�W��</th>
		<th>�Ϥ�</th>
		<th>�ƶq</th>
		<th>����</th>
		<% while(it.hasNext()){ %>
		<tr>
			<%String key = it.next();
				Product p = proMap.get(key);
			%>
				<td><%=p.getName()%></td>
				<td><img src="..<%=p.getPic()%>" width="100px" heigh="100px"></td>
				<td>
					<select name="quantity">
						<option value="<%=p.getQuantity() %>" selected><%=p.getQuantity() %></option>
					</select>
				</td>		
				<td><%=p.getPrice()*p.getQuantity() %></td>		
				<form action="delOneProduct" method="post">		
					<input type="hidden" name="name" value="<%=p.getName()%>">
					<input type="hidden" name="">
					<td><button>�s��</button></td>
					<td><button>�R��</button></td>
				</form>
		</tr>
		<%} %>
	</table>
	<td>�ӫ~���: <%=shopCart.getTotalQuantity() %>��</td>	
	<td>�`���B: <%=shopCart.getTotalPrice()%>��</td>
			<form action="delAllProduct" method="post">
				<td>
					<button>Delete ALL</button>
				</td>
			</form>
</body>
</html>