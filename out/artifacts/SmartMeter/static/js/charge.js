/** 页面大小改变时重新加载 */
window.onresize = function(){
	window.frame["c_section"].reload();
}

/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackb(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackc(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackd(){
	   var obj = document.getElementById("balance");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("payment");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("urging");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("recharge");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;"
}

/** 充值交互 */
function recharge(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/deposit',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val(),
			"money":$("#money").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0) {
				alert("充值成功！");
			}
			else{
				alert(data["error"]);
			}
		}
	});
}

/** 余额查询数据交互 */
function balancequery(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/remain',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,5);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['building']+"</td>"
									+"<td>"+obj['room']+"</td>"
									+"<td>"+obj['name']+"</td>"
									+"<td>"+obj['phone']+"</td>"
									+"<td>"+obj['remain']+"</td></tr>"
					$("table").html(tableDate);
				})
			}
			else{
				if (data["errno"] != 0){
            	alert(data["error"]);
				}
            }
		}
	});
}

/** 缴费查询数据交互 */
function paymentquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/payment',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val(),
			"start":start,
			"over":end
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,5);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['time']+"</td>"
									+"<td>"+obj['building']+"</td>"
									+"<td>"+obj['room']+"</td>"
									+"<td>"+obj['payment']+"</td>"
									+"<td>"+obj['remain']+"</td></tr>"
					$("table").html(tableDate);
				})
			}
			else{
				if (data["errno"] != 0){
            	alert(data["error"]);
				}
            }
		}
	});
}


/** 催费查询数据交互 */
function urgingquery(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/remain',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CCreateTable(length,4);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['building']+"</td>"
									+"<td>"+obj['room']+"</td>"
									+"<td>"+obj['remain']+"</td></tr>"
					$("table").html(tableDate);
				})
			}
			else{
				if (data["errno"] != 0){
            	alert(data["error"]);
				}
            }
		}
	});
}

/** 催费下发数据交互 */
function urging(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'POST',
		url:'/SmartMeter/reminder',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
            if (data["errno"] != 0){
            	alert(data["error"]);
            }
		}
	});
}

/** 时间格式化函数 */
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    }
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1,(this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o) if (new RegExp("(" + k + ")").test(format))format = format.replace(RegExp.$1,RegExp.$1.length == 1 ? o[k] :("00" + o[k]).substr(("" + o[k]).length));
    return format;
}

/** json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}

/* 动态生成表格函数balance&payment */
function CreateTable(rowCount,cellCount)
{ 
   var table=$("<table id=\"table\">");
   table.appendTo($("#information"));
   for(var i=0;i<rowCount;i++)
   {
	  if (i%2==1)
		  var tr=$("<tr bgcolor=\"#f0f0f0\"></tr>");
	  else
		  var tr=$("<tr bgcolor=\"white\"></tr>");
      tr.appendTo(table);
      for(var j=0;j<cellCount;j++)
      {
        var td=$("<td width=\"20%\">"+i*j+"</td>");
         td.appendTo(tr);
      }
   }
   trend.appendTo(table);
   $("#information").append("</table>");
}

/* 动态生成表格函数urging */
function CCreateTable(rowCount,cellCount)
{ 
   var table=$("<table id=\"table\">");
   table.appendTo($("#information"));
   for(var i=0;i<rowCount;i++)
   {
	  if (i==1)
		  var tr=$("<tr bgcolor=\"#f0f0f0\"></tr>");
	  else{
		  if (i%2==1)
			  var tr=$("<tr bgcolor=\"#f0f0f0\"></tr>");
		  else
			  var tr=$("<tr bgcolor=\"white\"></tr>");
	  }
      tr.appendTo(table);
      for(var j=0;j<cellCount;j++)
      {
    	  if (j==0){
    		  var td=$("<td width=\"5%\"><input type=checkbox id='checkbox" +i+ "'></td>");
    	  }
    	  else
    		  var td=$("<td width=\"31.67%\">"+i*j+"</td>");
         td.appendTo(tr);
      }
   }
   trend.appendTo(table);
   $("#information").append("</table>");
}