<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${base }">
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function () {
		$("#d1").click(function () {
			$.post("mvc/json",function (data){
				if($("#p").html()==""){
					$.each(data,function (i,user){
						$("<p>"+user.user+" "+user.pwd+"</p>").appendTo("#p");
					});
				}
				$("#p").fadeToggle(5000);
			});
		});
	});
</script>
<body>
	<form action="mvc/toBye" method="post">
		用户名:<input type="text" name="user"><br>
		 密码:<input type="password" name="pwd"><br>
		  生日<input type="date"name="bir">
		  <input type="submit" value="提交">
	</form>
	
	<div>
		<a href="mvc/mavt">test</a>
	</div>
	
	
	<div>
		<a href="mvc/st">sessiontest</a>
	</div>
	
	<div>
		<button id="d1">老易这个沙雕</button>
		<p id="p"></p>
	</div>
		
	<div>
		<form action="mvc/upload" method="post" enctype="multipart/form-data">		
			<input type="file" name=file>
			<input type="submit" value="提交">
		</form>
	</div>
	
	
	
	
</body>
</html>