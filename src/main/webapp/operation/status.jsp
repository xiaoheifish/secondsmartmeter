<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/operation.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/table.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/operation.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>communication</title>
<title>status</title>
</head>


<body  onload="cb()">
<div style="font-family:Ƽ��-��;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:2%;">

IMEI�ţ�
<span><select class="choice" id="IMEI" name="IMEI">  
    <option value="1">321654978235372</option>  
    <option value="2">296457322374624</option>  
</select> </span>

<input type="submit" value="��ѯ" onclick="statusquery()" class="button">
</div>

<!-- ���ر��  -->
<div  style="width:96%;height:300px;margin-top:5px;margin-left:2%;">
<table border="1" id="thead" >
    <tr>
    <th style="width:20%">IMEI��</th>
    <th style="width:80%">����״̬</th>
    </tr>
</table>

<table border="1" id="table" >
    <tr>
    <td style="width:20%">3</td>
    <td style="width:80%">4</td>
    </tr>
    <tr>
    <td>5</td>
    <td>6</td>
    </tr>
</table>
</div>
</body>
</html>