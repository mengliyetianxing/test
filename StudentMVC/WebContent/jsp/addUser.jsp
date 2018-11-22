<%@page import="pojo.Classinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	List<Classinfo> li = (List)request.getAttribute("li");
	String mess = (String)request.getAttribute("mess");
	if(mess==null){
		mess = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>项目管理系统 by www.codefans.net</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>

<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}


function link(){
alert('保存成功！');
    document.getElementById("fom").action="xuqiumingxi.htm";
   document.getElementById("fom").submit();
}

// var xmlhttp;
// function checkName(name) {
// 	if(window.XMLHttpRequest){
// 		xmlhttp = new XMLHttpRequest();
// 	}else{
// 		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
// 	}
// 	xmlhttp.onreadystatechange=reback;
// 	xmlhttp.open("post","checkName?name="+encodeURI(name),true);
// 	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
// 	xmlhttp.send();
	
// }

// function reback() {
// 	if (xmlhttp.readyState==4 && xmlhttp.status==200){
// 		if(xmlhttp.responseText=="true"){
// 			document.getElementById("err").style.color="red";
// 			document.getElementById("err").innerHTML="用户名已被占用";
// 		}else {
// 			document.getElementById("err").style.color="green";
// 			document.getElementById("err").innerHTML="用户名可用";
// 		}
// 	}
// }

	
	
	$(document).ready(function () {
		$("#i1").blur(function () {
			$.post("checkName?name="+encodeURI($("#i1").val()),function(data){
				if(data=="true"){
					$("#err").css("color","red");
					$("#err").html("用户名被占用");
				}else{
					$("#err").css("color","green");
					$("#err").html("用户名可用");
				}
			});
		});
	});

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="comform" method="post">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >学员添加页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="submit" name="Submit" value="保存" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>

		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>添加学员</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">名字:</td>
					    <td width="41%"><input name="name" class="text" style="width:250px" type="text" size="40" id="i1"/>
				        <span class="red"> *</span><span id="err"></span></td>
					    <td align="right" width="19%">密码:</td>
					    <td width="27%"><input name="password" id="Input22" class="text" style="width:154px" /></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">sex:</td>
					    <td>男<input name="sex" type="radio" value="男"/>
					    	女<input name="sex" type="radio" value="女"/>
					    </td>
					    <td align="right">生日:</td>
					    <td><input name="birthday" id="Input" class="text" style="width:154px" type="date" /></td>
					  </tr>
					   <tr>
					    <td nowrap align="right">班级:</td>
					    <td><select name="select2" >
                          <%
                          	if(li!=null)
                          	for(Classinfo c:li){
                          %>
                          	<option value="<%=c.getCid()%>"><%=c.getCname() %></option>
                          <%		
                          	}
                          %>
                        </select></td>
					    <td align="right">爱好:</td>
					    <td><select name="select" >
                          <option  selected="selected">==请选择==</option>
                          <option>steam</option>
                          <option>origin</option>
                          <option>uplay</option>
                          <option>gog</option>
                          <option>wegay</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td nowrap align="right" height="120px">备注:</td>
					    <td colspan="3"><textarea id="textarea" name="textarea" rows="5" cols="80"></textarea></td>
					    </tr>
					  </table>
			 <br />
				</fieldset>			</TD>
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
  

		
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/><span><%=mess %></span></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>