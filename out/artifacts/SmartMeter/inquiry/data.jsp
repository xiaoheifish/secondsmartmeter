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
<!-- ��Ϣѡ������ѡ��¥�ŵȣ� -->
<div style="font-family:Ƽ��-��;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:-4px;margin-left:2%;">
¥�ţ�
<span><select class="ichoice" id="building">  
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;�Һţ�
<span><select class="ichoice" id="room">  
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;&nbsp;&nbsp;ѡ��ʱ�䣺
<input type="datetime-local" id="start" class="time" value="������">
-
<input type="datetime-local" id="end" class="time" value="������">
<input type="submit" value="��ѯ" class="ibutton" onclick="dataquery()">
</div>

<!-- ���ر��  -->
<div  id="information" style="width:96%;height:150px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
    <th style="width:16.6%">ʱ��</th>
    <th style="width:16.6%">¥��</th>
    <th style="width:16.6%">�Һ�</th>
    <th style="width:16.6%">��ѹ</th>
    <th style="width:16.6%">����</th>
    <th style="width:16.6%">����</th>
    </tr>
</table>
</div>
</body>
</html>