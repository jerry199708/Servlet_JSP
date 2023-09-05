<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
    <title>Image Display</title>
</head>
<body>
    <h1>Image Display</h1>
    <img src="D:/images/<%=request.getAttribute("fileName")%>">
</body>
</html>
