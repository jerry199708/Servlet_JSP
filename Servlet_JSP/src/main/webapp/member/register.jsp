<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
  <title>�|���s�W</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/register.css">	
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div class="container">
    <h2>�|�����U</h2>
    <form action="#" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="name">�m�W:</label>
        <input type="text" id="name" name="name" >
      </div>
      <div class="form-group">
        <label for="email">�q�l�l��:</label>
        <input type="email" id="email" name="email" >
      </div>
      <div class="form-group">
        <label for="password">�K�X:</label>
        <input type="password" id="password" name="password" >
      </div>
      <div class="form-group">
        <label for="phone">�q��:</label>
        <input type="tel" id="phone" name="phone" >
      </div>
      <div class="form-group">
        <label for="pic">�Ϥ�:</label>
        <input type="file" id="pic" name="pic" accept="image/*" >
      </div>
      <div class="form-group">
        <input type="button" id="add" value="�s�W" class="btn btn-primary">
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