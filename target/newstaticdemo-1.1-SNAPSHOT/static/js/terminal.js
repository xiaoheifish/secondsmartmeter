/** 页面大小改变时重新加载 */
window.onresize = function(){
	window.frame["t_section"].reload();
}

/** 更改选中的后背景函数：changeback*() */
function changebacka(){
	   var obj = document.getElementById("add_delete");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;margin-left:-0.5%;"
	   var obj = document.getElementById("change");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;"
}

function changebackb(){
	   var obj = document.getElementById("add_delete");
	   obj.style.cssText = "background-color:#0e9c76;color:#e9e9e9;margin-left:-0.5%;"
	   var obj = document.getElementById("change");
	   obj.style.cssText = "background-color:#066b65;font-size:14px;color:white;"
}

