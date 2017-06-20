<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/charge.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/charge.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>urging</title>
</head>

<body>
<!-- 信息选择栏（选择楼号等） -->
<div style="font-family:萍方-简;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:1.9%;">
楼号：
<span><select class="cchoice" id="building" name="building"> 
	<option value="all">全部</option>     
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;室号：
<span><select class="cchoice" id="room" name="room"> 
	<option value="all">全部</option>     
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

<input type="submit" value="查询" onclick="urgingquery()" class="cbutton">
</div>


<!-- 加载表格  -->
<div  id="information" style="width:96%;height:250px;margin-left:2%;margin-top:5px;">
<table border="1" id="thead">
    <tr>
    <th style="width:5%"><input type="checkbox" id="checkboxall" /></th>
    <th style="width:31.67%">楼号</th>
    <th style="width:31.67%">室号</th>
    <th style="width:31.67%">当前余额</th>
    </tr>
</table>
</div>

<!-- 催费模板  -->
<div style="font-family:萍方-简;font-size:14px;color:#6a6969;margin-left:2%;">
催费内容：<br/>
<textarea name="urging" style="font-family:萍方-简;font-size:12px;color:#6a6969;width:97%;height:100px;margin-top:5px;line-height:15px;border:solid 1px #0e9c76;outline:none;padding-top:5px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您的电力账户已欠费，请尽快缴费!</textarea>
<br/>
<input type="submit" value="催费下发" onclick="urging()" class="cbutton" style="background-color:#0e9c76;margin-top:5px;margin-left:89.8%;">
</div>
</body>
</html>