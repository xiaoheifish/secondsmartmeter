<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/charge.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/charge.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>recharge</title>
</head>

<body>
<!-- ��Ϣѡ������ѡ��¥�ŵȣ� -->
<div style="font-family:Ƽ��-��;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:1.9%;">
¥�ţ�
<span><select class="cchoice" id="building"> 
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;�Һţ�
<span><select class="cchoice" id="room">
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;&nbsp;&nbsp;��ֵ��
<input type="text" id="money" size=18 value="�������ֵ���" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:15.3%;padding-left:10px;outline:none;"
	   onblur="this.value = '�������ֵ���'" onfocus="this.value = ''" onkeyup="value=value.replace(/[^\d]/g,'') ">&nbsp;&nbsp;Ԫ
<input type="submit" value="��ֵ" onclick="recharge()" class="cbutton" style="background-color:#0e9c76;margin-left:2.8%;">
</div>
</body>
</html>