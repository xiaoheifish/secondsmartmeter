<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/charge.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/charge.js"></script>
<title>terminal</title>
</head>

<body style="background-color:#efeff4;" onload="load()">
<!-- �˵�����4����ť -->
<div>
<a href="/SmartMeter/charge/recharge.jsp" target="c_section">
<button id="recharge" class="menu" onclick="changebackd();"  style="background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;">
�˹���ֵ
</button>
</a>

<a href="/SmartMeter/charge/balance.jsp" target="c_section">
<button id="balance" class="menu" onclick="changebacka();">
����ѯ
</button>
</a>

<a href="/SmartMeter/charge/payment.jsp" target="c_section">
<button id="payment" class="menu" onclick="changebackb();">
�ɷѲ�ѯ
</button>
</a>

<a href="/SmartMeter/charge/urging.jsp" target="c_section">
<button id="urging" class="menu" onclick="changebackc();">
�߷ѿ���
</button>
</a>
</div>


<!-- ��Ϣ��ʾ�� -->
<div style="height:568px;width:101.7%;background-color:white;margin-top:10px;margin-left:-1%;">
<iframe src="/SmartMeter/charge/recharge.jsp" width="100%" height="100%" frameborder="0" name="c_section">
</iframe>
</div>



</body>
</html>