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
<!-- ��Ϣѡ������ѡ��¥�ŵȣ� -->
<div style="font-family:Ƽ��-��;font-size:16px;height:66px;line-height:66px;width:99.6%px;background-color:white;vertical-align:middle;margin-top:10px;margin-left:1.9%;">
¥�ţ�
<span><select class="cchoice" id="building" name="building"> 
	<option value="all">ȫ��</option>     
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

&nbsp;&nbsp;�Һţ�
<span><select class="cchoice" id="room" name="room"> 
	<option value="all">ȫ��</option>     
    <option value="1">1</option>  
    <option value="2">2</option>  
</select> </span>

<input type="submit" value="��ѯ" onclick="urgingquery()" class="cbutton">
</div>


<!-- ���ر��  -->
<div  id="information" style="width:96%;height:250px;margin-left:2%;margin-top:5px;">
<table border="1" id="thead">
    <tr>
    <th style="width:5%"><input type="checkbox" id="checkboxall" /></th>
    <th style="width:31.67%">¥��</th>
    <th style="width:31.67%">�Һ�</th>
    <th style="width:31.67%">��ǰ���</th>
    </tr>
</table>
</div>

<!-- �߷�ģ��  -->
<div style="font-family:Ƽ��-��;font-size:14px;color:#6a6969;margin-left:2%;">
�߷����ݣ�<br/>
<textarea name="urging" style="font-family:Ƽ��-��;font-size:12px;color:#6a6969;width:97%;height:100px;margin-top:5px;line-height:15px;border:solid 1px #0e9c76;outline:none;padding-top:5px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���ĵ����˻���Ƿ�ѣ��뾡��ɷ�!</textarea>
<br/>
<input type="submit" value="�߷��·�" onclick="urging()" class="cbutton" style="background-color:#0e9c76;margin-top:5px;margin-left:89.8%;">
</div>
</body>
</html>