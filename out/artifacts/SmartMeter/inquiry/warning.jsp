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
ѡ��ʱ�䣺
<input type="datetime-local" id="start" class="time" value="������">
-
<input type="datetime-local" id="end" class="time" value="������">

<input type="submit" value="��ѯ" onclick="warningquery()" class="ibutton">

<!-- ʱ���3����ť  -->

<button id="week" class="select" onclick="cb();" style="margin-left:20px;">
��һ��
</button>

<button id="month" class="select" onclick="changebackb();">
��һ��
</button>

<button id="year" class="select" onclick="changebackc();">
��һ��
</button>
</div>

<!-- ���ر��  -->
<div  id="information" style="width:96%;height:300px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead">
    <tr>
    <th id="imei" style="width:16.67%">�ն�IMEI</th>
    <th id="building" style="width:16.67%">¥��</th>
    <th id="room" style="width:16.67%">�Һ�</th>
    <th id="type" style="width:16.67%">�澯����</th>
    <th id="info" style="width:16.67%">�澯��Ϣ</th>
    <th id="time" style="width:16.67%">ʱ��</th>
    </tr>
</table>

</div>
</body>
</html>