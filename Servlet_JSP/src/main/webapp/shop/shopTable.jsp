<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()+"/shop/shopCart.jsp"%>">�^�ʪ���</a>
	<table>
		<th>�W��</th>
		<th>�Ϥ�</th>
		<th>�ƶq</th>
		<th>����</th>
		<th>�\��</th>
		<tr>
			<form action="addProduct" action="post">
				<td>Macbook Pro 32g 1tb</td>
				<td><img src="../images/m.jpg" width="100px" heigh="100px"></td>
				<td>
					<select name="quantity">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</td>
				<td>$46900</td>
				<input type="hidden" name="name" value="Macbook Pro 32g 1tb">
				<input type="hidden" name="pic" value="/images/m.jpg">
				<input type="hidden" name="price" value="46900">
				<td><button type="submit">��J�ʪ���</button></td>
			</form>
		</tr>
		<tr>
			<form action="addProduct" action="post">
				<td>Iphone 14 pro max 64g</td>
				<td><img src="../images/i.jpg" width="100px" heigh="100px"></td>
				<td>
					<select name="quantity">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				</td>
				<td>$39900</td>
				<input type="hidden" name="name" value="Iphone 14 pro max 64g">
				<input type="hidden" name="pic" value="/images/i.jpg">
				<input type="hidden" name="price" value="39900">
				<td><button type="submit">��J�ʪ���</button></td>
			</form>
		</tr>
	</table>
</body>
</html>