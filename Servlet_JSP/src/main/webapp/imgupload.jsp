<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
    <title>Image Upload</title>
</head>
<body>
    <h1>Image Upload</h1>
    <form action="ImageServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="imageFile">
        <input type="submit" value="Upload">
    </form>
</body>
</html>
