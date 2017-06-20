<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script language="javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<script language="javascript" src="/SmartMeter/static/js/inquiry.js"></script>
<title>data</title>

</head>
<body>
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:-4px;margin-left:2%;">
楼号：
<span><select class="ichoice" id="building">  
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="ichoice" id="room">  
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;&nbsp;&nbsp;选择时间：
<input type="datetime-local" id="start" class="time" value="年月日">
-
<input type="datetime-local" id="end" class="time" value="年月日">
<input type="submit" value="查询" class="ibutton" onclick="dataquery()">
</div>

<!-- 加载表格  -->
<div  id="information" style="width:96%;height:150px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
    <th style="width:16.6%">时间</th>
    <th style="width:16.6%">楼号</th>
    <th style="width:16.6%">室号</th>
    <th style="width:16.6%">电压</th>
    <th style="width:16.6%">电流</th>
    <th style="width:16.6%">电量</th>
    </tr>
</table>
</div>
</body>
</html>