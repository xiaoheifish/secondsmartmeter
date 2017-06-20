<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/operation.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/operation.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>run_stop</title>
</head>

<body>
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:2%;">
楼号：
<span><select class="choice" id="building" name="building">   
	<option value="all">全部</option>     
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="choice" id="room" name="room">  
	<option value="all">全部</option>      
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

<input type="submit" value="查询" onclick="query()" class="button">
<input type="submit" value="开启电表" onclick="start()" class="button" style="margin-left:40px;width:15%;">
<input type="submit" value="停止电表" onclick="stop()" class="button" style="background:#f2737e;width:15%;">
</div>

<!-- 加载表格  -->
<div  id="information" style="width:96%;height:150px;margin-left:2%;margin-top:5px;">
<table border="1" id="thead" >
    <tr>
    <th style="width:5%"><input type="checkbox" name="all" /></th>
    <th style="width:31.6%">楼号</th>
    <th style="width:31.6%">室号</th>
    <th style="width:31.6%">运行状态</th>
    </tr>
</table>

</div>
</body>
</html>