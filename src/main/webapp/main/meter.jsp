<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/terminal.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/meter.js"></script>
<title>meter</title>
</head>


<body style="background-color:#efeff4;">
<!-- �˵�����2����ť -->
<div>
<a href="/SmartMeter/terminal/m_add.jsp" target="t_section" >
<button id="m_add" class="menu" onclick="changebacka();" style="background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;">
�������
</button>
</a>

<a href="/SmartMeter/terminal/m_delete.jsp" target="t_section">
<button id="m_delete" class="menu" onclick="changebackb();" >
���ɾ��
</button>
</a>

</div>

<!-- ��Ϣ��ʾ�� -->
<div style="height:568px;width:101.7%;background-color:white;margin-top:10px;margin-left:-1%;">
<iframe src="/SmartMeter/terminal/m_add.jsp" width="100%" height="100%" frameborder="0" name="t_section">
</iframe>
</div>

</body>
</html>