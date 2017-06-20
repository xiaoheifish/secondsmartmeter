/** 页面大小改变时重新加载 */
window.onresize = function(){
	window.frame["c_section"].reload();
}

/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackb(){
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
}

function changebackc(){
	   var obj = document.getElementById("communication");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("status");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("run_stop");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;"
}

/** 电表运行状态查询数据交互 */
function query(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/meter/data',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
		},
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,4);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['building']+"</td>"
									+"<td>"+obj['room']+"</td>"
									+"<td>"+obj['status']+"</td></tr>"
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

/** 电表开启交互 */
function start(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/command/start_stop',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val(),
			"command":1
		},
		dataType:'json',
		success:function(data){
            if (data["errno"] == 0){
            	alert("电表开启成功！");
            }
            else{
            	alert(data["error"]);
            }
		}
	});
}

/** 电表停止交互 */
function stop(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/command/start_stop',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val(),
			"command":01
		},
		dataType:'json',
		success:function(data){
            if (data["errno"] == 0){
            	alert("电表停止成功！");
            }
            else{
            	alert(data["error"]);
            }
		}
	});
}

/* 暂时没有！ */
/* 通信状态查询数据交互 */
function comquery(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/terminal/data',
		data:{
			"IMEI":$("#IMEI").val()
		},
		dataType:'json',
		success:function(data){
			if(getJsonObjLength(data[0]) != 0){
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['IMEI']+"</td>"
									+"<td>"+obj['sim']+"</td>"
									+"<td>"+obj['simRemain']+"</td></tr>"
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

/** 终端状态查询数据交互 */
function statusquery(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/xhr/terminal/data',
		data:{
			"IMEI":$("#IMEI").val()
		},
		dataType:'json',
		success:function(data){
			if(getJsonObjLength(data[0]) != 0){
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['IMEI']+"</td>"
									+"<td>"+obj['status']+"</td></tr>"
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

/** json数据长度 */
function getJsonObjLength(jsonObj) {
    var Length = 0;
    for (var item in jsonObj) {
        Length++;
    }
    return Length;
}

/* 动态生成表格函数-电表 */
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
    	  if(j==0)
    		  var td=$("<td width=\"5%\"><input type=checkbox id='meter" +i+ "'></td>");
    	  else
    		  var td=$("<td width=\"31.6%\">"+i*j+"</td>");
         td.appendTo(tr);
      }
   }
   trend.appendTo(table);
   $("#information").append("</table>");
}