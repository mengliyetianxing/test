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
<title>项目管理系统 by www.codefans.net</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="images/top.gif"><table width="99%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="1%"><a href="http://www.codefans.net/admin-templates/" target="_blank"><img src="images/logo.gif" width="557" height="59" border="0" /></a></td>
        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">&copy; 2009 <a href="http://www.codefans.net/admin-templates/" style="color:#0099FF;text-decoration:none;">www.codefans.net</a> QQ:123456 Email:123456@qq.com</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
