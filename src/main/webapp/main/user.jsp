<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/user.css"/>
<link rel="stylesheet" type="text/css" href="/SmartMeter/static/css/table.css"/>
<script type="text/javascript" src="/SmartMeter/static/js/user.js"></script>
<script type="text/javascript" src="/SmartMeter/static/js/jquery-3.2.1.min.js"></script>
<title>user</title>
</head>

<body style="background-color:#efeff4;">
<!-- �˵�����3����ť -->
<div>
<button id="operator" class="menu" onclick="">
����Ա����
</button>
</div>

<!-- ��Ϣ��ʾ�� -->
<div style="height:565px;width:101.7%;background-color:white;margin-top:-10px;margin-left:-1%;">
<div style="margin-left:2.5%;margin-top:25px;">
����Ա�˺ţ�
<input type="text" size=18 value="����admin" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onblur="this.value = '����admin'" onfocus="this.value = ''">
&nbsp;&nbsp;����Ա������
<input type="text" size=18 value="��������" style="color:#6a6969;border-style:solid;border-color:#0e9c76;border-width:1.5px;height:30px;width:158px;padding-left:10px;outline:none;margin-top:26px;"
	   onblur="this.value = '����admin'" onfocus="this.value = ''">
<input type="submit" value="��ѯ" class="sub" onclick="query()">
<input type="submit" value="����" class="sub" onclick="openEdit()">
</div>

<!-- ���ر��  -->
<div  id="information" style="width:96%;height:150px;margin-left:2.5%;margin-top:20px;">
<table border="1" id="thead" >
    <tr>
    <th style="width:18%">����Ա�˺�</th>
    <th style="width:18%">����Ա����</th>
    <th style="width:18%">�绰</th>
    <th style="width:18%">����</th>
    <th style="width:18%">Ȩ��</th>
    <th style="width:10%">�༭</th>
    </tr>
</table>
</div>
</div>

<!-- �����༭���� -->
<script>
function openEdit(){
	   document.getElementById("edit").style.display="";
	}
function closeEdit(){
	   document.getElementById("edit").style.display="none";
	}
</script>

<!-- �û��༭���� -->
<div id="edit" style="display:none; POSITION:absolute; left:400px; top:60px; width:299px; height:420px; border:1px solid #888; background-color:white;">
<div id="ttitle">�û��༭</div>
<div style="margin-left:30px;margin-top:8px;font-size:14px;">
��ţ�<input type="text" class="tinput" id="number" size=20 value="���������" onblur="this.value = '���������'" onfocus="this.value = ''"><br/>

�˺ţ�<input type="text" class="tinput" id="account" size=20 value="�������˺�" onblur="this.value = '�������˺�'" onfocus="this.value = ''"><br/>

���룺<input type="text" class="tinput" id="password" size=20 value="����������" onblur="this.value = '����������'" onfocus="this.value = ''"><br/>

������<input type="text" class="tinput" id="name" size=20 value="����������" onblur="this.value = '����������'" onfocus="this.value = ''"><br/>

�ֻ���<input type="text" class="tinput" id="phone" size=20 value="�������ֻ�����" onblur="this.value = '�������ֻ�����'" onfocus="this.value = ''"><br/>

���䣺<input type="text" class="tinput" id="email" size=20 value="����������" onblur="this.value = '����������'" onfocus="this.value = ''"><br/>

Ȩ�ޣ�
<span><select id="tcompetence">  
    <option value="1">�߼�</option>  
    <option value="2">�м�</option>  
</select> </span>
</div>

<input type="submit" value="����" class="tbutton" style="margin-left:70px;background-color:#0e9c76;">
<input type="submit" value="ȡ��" class="tbutton" style="background-color:#f2737e;" onclick="closeEdit()">

</div>

</body>
</html>