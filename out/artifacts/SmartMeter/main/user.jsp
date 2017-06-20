<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/user.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/user.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>user</title>
</head>

<body style="background-color:#efeff4;">
<!-- 菜单栏的3个按钮 -->
<div>
<button id="operator" class="menu" onclick="">
操作员管理
</button>
</div>

<!-- 信息显示栏 -->
<div style="height:565px;width:101.7%;background-color:white;margin-top:-10px;margin-left:-1%;">
<div style="margin-left:2.5%;margin-top:25px;">
操作员账号：
<input type="text" size=18 value="例：admin" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onblur="this.value = '例：admin'" onfocus="this.value = ''">
&nbsp;&nbsp;操作员姓名：
<input type="text" size=18 value="例：张三" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onblur="this.value = '例：admin'" onfocus="this.value = ''">
<input type="submit" value="查询" class="sub" onclick="query()">
<input type="submit" value="新增" class="sub" onclick="openEdit()">
</div>

<!-- 加载表格  -->
<div  id="information" style="width:96%;height:150px;margin-left:2.5%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
    <th style="width:18%">操作员账号</th>
    <th style="width:18%">操作员姓名</th>
    <th style="width:18%">电话</th>
    <th style="width:18%">邮箱</th>
    <th style="width:18%">权限</th>
    <th style="width:10%">编辑</th>
    </tr>
</table>
</div>
</div>

<!-- 弹出编辑窗口 -->
<script>
function openEdit(){
	   document.getElementById("edit").style.display="";
	}
function closeEdit(){
	   document.getElementById("edit").style.display="none";
	}
</script>

<!-- 用户编辑窗口 -->
<div id="edit" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:420px; border:1px solid #888; background-color:white;">
<div id="ttitle">用户编辑</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
序号：<input type="text" class="tinput" id="number" size=20 value="请输入序号" onblur="this.value = '请输入序号'" onfocus="this.value = ''"><br/>

账号：<input type="text" class="tinput" id="account" size=20 value="请输入账号" onblur="this.value = '请输入账号'" onfocus="this.value = ''"><br/>

密码：<input type="text" class="tinput" id="password" size=20 value="请输入密码" onblur="this.value = '请输入密码'" onfocus="this.value = ''"><br/>

姓名：<input type="text" class="tinput" id="name" size=20 value="请输入姓名" onblur="this.value = '请输入姓名'" onfocus="this.value = ''"><br/>

手机：<input type="text" class="tinput" id="phone" size=20 value="请输入手机号码" onblur="this.value = '请输入手机号码'" onfocus="this.value = ''"><br/>

邮箱：<input type="text" class="tinput" id="email" size=20 value="请输入邮箱" onblur="this.value = '请输入邮箱'" onfocus="this.value = ''"><br/>

权限：
<span><select id="tcompetence">  
    <option value="1">高级</option>  
    <option value="2">中级</option>  
</select> </span>
</div>

<input type="submit" value="保存" class="tbutton" style="margin-left:70px;background-color:#0e9c76;">
<input type="submit" value="取消" class="tbutton" style="background-color:#f2737e;" onclick="closeEdit()">

</div>

</body>
</html>