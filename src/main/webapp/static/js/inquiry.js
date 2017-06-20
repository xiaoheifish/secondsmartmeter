/* 页面大小改变时重新加载 */
window.onresize = function(){
	window.frame["i_section"].reload();
}

/* 判断是否从首页跳转到数据查询 */
function load(){
	 if (parent.document.getElementById("1") != null){
		 document.getElementById("data").click();
	    }
}

/* 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackb(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackc(){
	   var obj = document.getElementById("warning");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("data");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("dairy");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
}

/* 时间格式化函数 */
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

/* 告警查询数据交互 */
function warningquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/SmartMeter/alarm/query',
		data:{
			"begin":start,
			"end":end
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,6);
				var tableDate = "";
		            $.each(data,function(id,obj){
		                tableDate += "<tr><td>"+obj['time']+"</td>"
		                			  +"<td>"+obj['IMEI']+"</td>"
		                              +"<td>"+obj['building']+"</td>"
		                              +"<td>"+obj['room']+"</td>"
		                              +"<td>"+obj['type']+"</td>"
		                              +"<td>"+obj['info']+"</td></tr>"
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


/** 数据查询交互 */
function dataquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/SmartMeter/data/query',
		data:{
			"begin":start,
			"end":end,
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,6);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['time']+"</td>"
									+"<td>"+obj['building']+"</td>"
									+"<td>"+obj['room']+"</td>"
									+"<td>"+obj['voltage']+"</td>"
									+"<td>"+obj['current']+"</td>"
									+"<td>"+obj['power']+"</td></tr>"
									$("table").html(tableDate);
				})
			}
			else{
				if(data["errno"] != 0){
            	alert(data["error"]);
				}
            }
		}
	});
}

/** 日志查询交互 */
function dairyquery(){
	var start=new Date($("#start").val()).format('yyyy-MM-dd hh:mm:ss');
	var end=new Date($("#end").val()).format('yyyy-MM-dd hh:mm:ss');
	$.ajax({
		type:'GET',
		url:'/SmartMeter/log/query',
		data:{
			"begin":start,
			"end":end,
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CCreateTable(3,length);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['time']+"</td>"
									+"<td>"+obj['operation']+"</td>"
									+"<td>"+obj['info']+"</td></tr>"
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

/* json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}

/* 动态生成表格函数warning&data */
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
        var td=$("<td width=\"16.67%\">"+i*j+"</td>");
         td.appendTo(tr);
      }
   }
   //trend.appendTo(table);
   $("#information").append("</table>");
}

/* 动态生成表格函数dairy */
function CCreateTable(rowCount,cellCount)
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
    	  if (j==0||1)
	    	var td=$("<td width=\"20%\">"+i*j+"</td>");
    	  if (j==2)
  	    	var td=$("<td width=\"60%\">"+i*j+"</td>");
    	  
         td.appendTo(tr);
      }
   }
   trend.appendTo(table);
   $("#information").append("</table>");
}