<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
  <title>會員新增</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/register.css">	
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div class="container">
    <h2>會員註冊</h2>
    <form action="#" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="name">姓名:</label>
        <input type="text" id="name" name="name" >
      </div>
      <div class="form-group">
        <label for="email">電子郵件:</label>
        <input type="email" id="email" name="email" >
      </div>
      <div class="form-group">
        <label for="password">密碼:</label>
        <input type="password" id="password" name="password" >
      </div>
      <div class="form-group">
        <label for="phone">電話:</label>
        <input type="tel" id="phone" name="phone" >
      </div>
      <div class="form-group">
        <label for="pic">圖片:</label>
        <input type="file" id="pic" name="pic" accept="image/*" >
      </div>
      <div class="form-group">
        <input type="button" id="add" value="新增" class="btn btn-primary">
      </div>
    </form>
  </div>
		<script>
			var add = $('#add');
			add.on('click',function(){
				var name = $('#name').val();
				var email = $('#email').val();
				var password = $('#password').val();
				var phone = $('#phone').val();
				var pic = $('#pic').val();
			});
		</script>
	</body>
</html>