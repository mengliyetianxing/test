<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Classinfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<base href="${base }">
<meta charset="UTF-8">
<title>项目管理系统 by www.codefans.net</title>
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />


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



</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
  <form action="updateuser" method="post">
  <input type="hidden" name = "uid" value="${uid }">
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >学员修改页面</th>
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
				<legend>修改学员</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">姓名:</td>
					    <td width="43%"><input name="name" value="${name }" class="text" style="width:250px" type="text" size="40" />
				        <span class="red"> *</span></td>
					    <td align="right" width="17%">密码:</td>
					    <td width="27%"><input name="password" value="${password }" id="Input22" class="text" style="width:154px" /></td>
					    </tr>
					  <tr>
					    <td nowrap align="right">sex:</td>
					   <c:if test="${sex=='男' }">
					   		<td>
					    	男<input name="sex" type="radio" value="男" checked="checked"/>
					    	女<input name="sex" type="radio" value="女"/>
					    	</td>
					   </c:if>
					    <c:if test="${sex=='女' }">
					   		<td>
					    	男<input name="sex" type="radio" value="男" />
					    	女<input name="sex" type="radio" value="女" checked="checked"/>
					    	</td>
					   </c:if>

					    <td align="right">生日:</td>
					    <td><input name="birthday" value="${birthday }" id="Input" class="text" style="width:154px" type="date" /></td>
					  </tr>
					  
					   <tr>
					    <td nowrap align="right">班级:</td>
					    <td><select name="select2" >
                         <c:forEach items="${li}" var="c">
                         	 <option value="${c.cid}" <c:if test="${cla==c.cid }"> selected="selected"</c:if>>
                         	 ${c.cname} 
                         	  </option>
                         </c:forEach>
                           </select></td>
					    <td align="right">爱好:</td>
					    <td>
					    <select name="select" >
					   		
					   		<c:forEach items="${lis }" var="l">
					   			<option selected="selected" >${l }</option>
					   		</c:forEach>
					    	
                        </select></td>
					  </tr>
					  <tr>
					    <td nowrap align="right" height="120px">备注:</td>
					    <td colspan="3"><textarea id="textarea" name="textarea" rows="5" cols="80" ></textarea></td>
					    </tr>
					  </table>
			 <br/>
				</fieldset>			</TD>
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
  

		
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/><span>${mess }</span></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
