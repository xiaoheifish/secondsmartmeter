<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/m_add_del.js"></script>
<title>c_add</title>
</head>

<body style="font-family:Ƽ��-��;font-size:16px;line-height:40px;">

<script language="javascript" type="text/javascript">   
        $(".add").click(function() {
        alert("Hello world!");
   });
</script>


<div style="margin-left:2%;margin-top:20px;">
�ն�IMEI�ţ�
<input type="text" id="imei" size=18 value="�������ն˺�" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:348px;padding-left:10px;outline:none;"
       onblur="this.value = '�������ն˺�'" onfocus="this.value = ''"><br>
</div>

<div id="add_div" style="margin-top:10px;margin-left:2%;">
����ţ�
<input type="text" id="meterId" size=18 value="����������" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:355px;padding-left:5px;margin-left:18px;outline:none;"
       onblur="this.value = '����������'" onfocus="this.value = ''">
&nbsp;&nbsp;&nbsp;
���λ�ã�
<input type="text" id="building" size=18 value="������¥��" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;"
       onblur="this.value = '������¥��'" onfocus="this.value = ''">
-
<input type="text" id="room" size=18 value="�������Һ�" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;"
       onblur="this.value = '�������Һ�'" onfocus="this.value = ''">
<input type="button" value=" " id="add" style="background-image:url(/SmartMeter/static/pic/terminal/add.png);width:30px;height:30px;border:none;outline:none;cursor:hand;margin-left:10px;margin-top:20px;" onclick="add()">
<input type="button" value=" " id="del" style="background-image:url(/SmartMeter/static/pic/terminal/delete.png);width:30px;height:30px;border:none;outline:none;cursor:hand;margin-left:10px;margin-top:20px;" onclick="del()">
</div>

<input type="button" value="�ύ" onclick="m_add()" style="background-color:#0e9c76;width:8%;height:30px;border:solid 1px #0e9c76;outline:none;font-size:14px;color:white;border-radius:3px;cursor:hand;margin-left:858px;margin-top:20px;">
</body>
</html>