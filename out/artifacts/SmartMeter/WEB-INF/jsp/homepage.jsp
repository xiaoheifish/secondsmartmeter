<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/homepage.css" />
<script type="text/javascript" src="/SmartMeter/static/js/homepage.js"></script>
</head>


<body style="height:100%">



<!-- 标题栏 -->
<div id="header">
&nbsp;&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/LOGO2.png" width="30" height="30" style="vertical-align:middle"/>
&nbsp;钛比科技&nbsp;&nbsp;智慧电表管理平台
<a href="javascript:openLogin();"><input type="button" id="login" value="登陆" style="margin-left:75%;font-family:萍方-简;font-size:12px;color:white;outline:none;border:none;background:transparent;">
</a></div>

<!-- 登录窗口 -->
<div id="Login" style="display:none; POSITION:absolute; left:100%; top:40%; width:280px; height:190px; margin-left:-300px; margin-top:-200px; border:1px solid #888; background-color:white;">
<div id="loginheader">&nbsp;&nbsp;<img src="/SmartMeter/static/pic/LOGO2.png" width="25" height="25" style="vertical-align:middle"/>&nbsp;&nbsp;钛比科技</div>
<div style="font-family:萍方-简;font-size:14px;margin-left:20px;">
账号：
<input type="text" class="input" id="number" size=20 value="请输入账号" onblur="this.value = '请输入账号'" onfocus="this.value = ''"><br/>

密码：
<input type="password" class="input" id="account" size=20 value="请输入密码" onblur="this.value = '请输入密码'" onfocus="this.value = ''"><br/>
<a href="" style="font-family:萍方-简;font-size:10px;color:blue;text-decoration:none;margin-left:115px;">注册一个新账号</a>
<a href="" style="font-family:萍方-简;font-size:10px;color:blue;text-decoration:none;margin-left:10px;">忘记密码？</a><br/>
<input type="submit" value="登录" class="submit" style="margin-left:20px;background-color:#0e9c76;">
<input type="submit" value="关闭" class="submit" style="background-color:#f2737e;margin-left:10px;" onclick="closeLogin();">
</div>
</div>


<!-- 导航栏内的6按钮 -->
<div id="menu" style="height:100%;position:absolute;z-index:1;">

<a href="/SmartMeter/main/mainpage.jsp" target="section">
<button id="mainpage" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackm();" style="background-image:url(/SmartMeter/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/mainpage.png" style="vertical-align:middle"/>
&nbsp;&nbsp;首页
</button>
</a>

<a href="/SmartMeter/main/meter.jsp" target="section">
<button id="meter" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackmm();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/meter.png" style="vertical-align:middle"/>
&nbsp;&nbsp;电表管理<br>
</button>
</a>

<a href="/SmartMeter/main/terminal.jsp" target="section">
<button id="terminal" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackt();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/terminal management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;采集器管理<br>
</button>
</a>


<a href="/SmartMeter/main/inquiry.jsp" target="section">
<button id="inquiry" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacki();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/inquiry.png" style="vertical-align:middle"/>
&nbsp;&nbsp;查询功能<br>
</button>
</a>

<a href="/SmartMeter/main/charge.jsp" target="section">
<button id="charge" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackc();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/charge.png" style="vertical-align:middle"/>
&nbsp;&nbsp;费控管理<br>
</button>
</a>

<a href="/SmartMeter/main/operation.jsp" target="section">
<button id="operation" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacko();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/operation management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;运行管理<br>
</button>
</a>

<a href="/SmartMeter/main/user.jsp" target="section">
<button id="user" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebacku();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/user management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;用户管理<br>
</button>
</a>
</div>

<!-- 右侧页面分块 -->
<div id="rightsection" style="width:100%;height:100%;position:absolute;z-index:0;left:0px;top:65px;">
<iframe src="/SmartMeter/main/mainpage.jsp" width="99%" height="99%" frameborder="0" name="section" style="background-color:#efeff4;margin-left:220px;margin-top:1%;">
</iframe>
</div>

</body>
</html>