<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$("#b1").click(function () {
			if($("tr").length==0){
				$.post("selectFile",function(data){
					$.each(JSON.parse(data),function(i,files) {
						$("<tr><td>"+files.fid+"</td><td>"+files.fname+"</td><td>"+files.fdes+"</td></tr>").appendTo("table");
					});
				});
			}
		});
	});
</script>
<body>
	<button id="b1">查看所有文件信息</button>
	<div style="width: 700px;margin: 0 auto;margin-top: 80px;height: 700px">
		<table></table>
	</div>
</body>
</html>