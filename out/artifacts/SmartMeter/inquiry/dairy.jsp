<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>dairy</title>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/warning.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
</head>

<body>

<div style="margin-top:20px;margin-left:2%;">
ѡ��ʱ�䣺
<input type="date" class="time" min="2013-01-01" value="������">
-
<input type="date" class="time" min="2013-01-01" alue="������">

&nbsp;&nbsp;&nbsp;&nbsp;ѡ����־���ͣ�
<span><select id="iselect" name="type" style="font-size:14px">  
    <option value="1">����</option>  
    <option value="2">�쳣�澯</option>  
</select> </span>
<input type="submit" value="��ѯ" class="ibutton" onclick="dairyquery()" style="margin-left:15px">
</div>

<!-- ���ر��  -->
<div  id="information" style="width:96%;height:300px;margin-left:2%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
	<th style="width:20%">ʱ��</th>
	<th style="width:20%">����Ա</th>
    <th style="width:60%">��־��Ϣ</th>
    </tr>
</table>
</div>
</body>
</html>