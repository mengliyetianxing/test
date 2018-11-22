<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin: 0px auto;width: 700px">
		<table style="width: 500px">
			<thead>
				<th>编号</th>
				<th>文件名</th>
				<th>描述</th>
				<th>操作</th>
			</thead>
			
			<c:forEach items="${li }" var="li">
			<tr style="text-align: center;">
				<td>${li.fid }</td>
				<td>${li.fname }</td>
				<td>${li.fdes }</td>
				<td>
					<a href="down?name=${li.fname }">下载</a>
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>