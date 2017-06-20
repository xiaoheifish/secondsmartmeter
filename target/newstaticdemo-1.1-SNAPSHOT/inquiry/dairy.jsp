<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>dairy</title>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
</head>

<body>

<div style="margin-top:20px;margin-left:2%;">
选择时间：
<input type="date" class="time" min="2013-01-01" value="年月日">
-
<input type="date" class="time" min="2013-01-01" alue="年月日">

&nbsp;&nbsp;&nbsp;&nbsp;选择日志类型：
<span><select id="iselect" name="type" style="font-size:14px">  
    <option value="1">操作</option>  
    <option value="2">异常告警</option>  
</select> </span>
<input type="submit" value="查询" class="ibutton" onclick="dairyquery()" style="margin-left:15px">
</div>

<!-- 加载表格  -->
<div  id="information" style="width:96%;height:300px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
	<th style="width:20%">时间</th>
	<th style="width:20%">操作员</th>
    <th style="width:60%">日志信息</th>
    </tr>
</table>
</div>
</body>
</html>