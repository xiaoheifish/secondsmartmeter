/** 页面大小改变时重新加载 */
window.onresize = function(){
	location.reload();
}

/** 增加电表提交数据 */
function m_add(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/meter/add',
		data:{
			"imei":$("#imei").val(),
			"meterId":$("#meterId").val(),
			"building":$("#building").val(),
			"room":$("#room").val()
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

/** 删除电表提交数据 */
function m_delete(){
	$.ajax({
		type:'POST',
		url:'/SmartMeter/meter/remove',
		data:{
			"building":$("#building").val(),
			"room":$("#room").val()
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



/** ！需要修改 增加行（电表-楼号-室号） */
function add() {
	 var len = $(".container").children().length + 1;
	    var divId = "5" + len;
	    var inputId = "input" + len;
	    if (len >= 11) {
	            alert("已经达到十个了");
	        return;
	    };
	    $(".container").append("<div id=" + divId + "><input type='text' id=" + inputId + "></div>");
}
