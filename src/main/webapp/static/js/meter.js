/** 页面大小改变时重新加载 */
window.onresize = function(){
	window.frame["t_section"].reload();
}

/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("m_add");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;"
	   var obj = document.getElementById("m_delete");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
	   var obj = document.getElementById("change");
}

function changebackb(){
	   var obj = document.getElementById("m_add");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("m_delete");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
}

/** 增加采集器数据交互 */
function add(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/terminal/add',
		data:{
			"imei":$("#newimei").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0) {
				alert("添加成功！");
			}
			else{
				alert(data["error"]);
			}
		}
	});
}

/** 删除采集器数据交互 */
function remove(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/terminal/remove',
		data:{
			"imei":$("#removeimei").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0) {
				alert("删除成功！");
			}
			else{
				alert(data["error"]);
			}
		}
	});
}

/** 更改采集器数据交互 */
function remove(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/terminal/change',
		data:{
			"oldImei":$("#oldimei").val(),
			"newImei":$("#newimei").val()
		},
		dataType:'json',
		success:function(data){
			if (data["errno"] == 0) {
				alert("更改成功！");
			}
			else{
				alert(data["error"]);
			}
		}
	});
}