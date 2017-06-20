<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/login.css" />
<script type="text/javascript" src="/SmartMeter/static/js/login.js"></script>
</head>


<body>

<!-- 标题栏 -->
<div id="header">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/LOGO2.png" width="30" height="30" style="vertical-align:middle"/>
&nbsp;钛比科技&nbsp;&nbsp;智慧电表管理平台
<br>
</div>

<!-- 导航栏内的6按钮 -->
<div id="menu">

<a href="/SmartMeter/main/mainpage.jsp" target="section">
<button id="mainpage" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackm();" style="background-image:url(/SmartMeter/static/pic/click_back.png);color:#066b65;font-weight:bold;background-size:100%;">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/mainpage.png" style="vertical-align:middle"/>
&nbsp;&nbsp;首页
</button>
</a>

<a href="/SmartMeter/main/terminal.jsp" target="section">
<button id="terminal" class="button" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'" onclick="this.className='d_click';changebackt();">
&nbsp;&nbsp;
<img src="/SmartMeter/static/pic/terminal management.png" style="vertical-align:middle"/>
&nbsp;&nbsp;终端和采集点管理<br>
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
<div id="section" >
<iframe src="/SmartMeter/main/mainpage.jsp" width="98%" height="97%" frameborder="0" name="section" style="background-color:#efeff4;margin-left:1%;margin-top:1%;">
</iframe>
</div>

</body>
</html>