<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/warning.js"></script>
<script language="javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/SmartMeter/static/js/inquiry.js"></script>
<title>warning</title>
</head>

<body>

<div style="margin-left:2%;margin-top:20px;" id="1">
选择时间：
<input type="datetime-local" id="start" class="time" value="年月日">
-
<input type="datetime-local" id="end" class="time" value="年月日">

<input type="submit" value="查询" onclick="warningquery()" class="ibutton">

<!-- 时间的3个按钮  -->

<button id="week" class="select" onclick="cb();" style="margin-left:20px;">
近一周
</button>

<button id="month" class="select" onclick="changebackb();">
近一月
</button>

<button id="year" class="select" onclick="changebackc();">
近一年
</button>
</div>

<!-- 加载表格  -->
<div  id="information" style="width:96%;height:300px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead">
    <tr>
    <th id="imei" style="width:16.67%">终端IMEI</th>
    <th id="building" style="width:16.67%">楼号</th>
    <th id="room" style="width:16.67%">室号</th>
    <th id="type" style="width:16.67%">告警类型</th>
    <th id="info" style="width:16.67%">告警信息</th>
    <th id="time" style="width:16.67%">时间</th>
    </tr>
</table>

</div>
</body>
</html>