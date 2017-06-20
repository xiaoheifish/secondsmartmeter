<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/meter.js"></script>
<title>change</title>
</head>
<body style="font-family:萍方-简;font-size:16px;line-height:40px;">

<div style="margin-left:2%;margin-top:20px;">
原终端IMEI号：
<input type="text" id="oldimei" size=18 value="请输入原终端号" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:348px;padding-left:10px;outline:none;"
	   onblur="this.value = '请输入原终端号'" onfocus="this.value = ''"><br>
</div>

<div style="margin-top:20px;margin-left:2%;">
新终端IMEI号：
<input type="text" id="newimei" size=18 value="请输入新终端号" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:348px;padding-left:10px;outline:none;"
	   onblur="this.value = '请输入新终端号'" onfocus="this.value = ''">
<input type="submit" value="提交" onclick="change()" style="background-color:#0e9c76;width:8%;height:30px;border:solid 1px #0e9c76;outline:none;font-size:14px;color:white;border-radius:3px;cursor:hand;margin-left:20px;">
</div>

</body>
</html>