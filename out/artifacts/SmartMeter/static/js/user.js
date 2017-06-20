/** 页面大小改变时重新加载 */
window.onresize = function(){
	document.location.reload();
}

/** 用户信息查询数据交互 */
function query(){
	$.ajax({
		type:'GET',
		url:'/SmartMeter/user/get',
		dataType:'json',
		success:function(data){
			var length=getJsonObjLength(data[0]);
			if(length != 0){
				CreateTable(length,6);
				var tableDate = "";
				$.each(data,function(id,obj){
					tableDate += "<tr><td>"+obj['account']+"</td>"
									+"<td>"+obj['name']+"</td>"
									+"<td>"+obj['phone']+"</td>"
									+"<td>"+obj['email']+"</td>"
									+"<td>"+obj['authority']+"</td></tr>"
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

/* 动态生成表格函数 */
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
    	  if(j==5)
    		  var td=$("<td width=\"10%\"><input type=button class=edit value=编辑 id='edit" +i+ "'></td>");
    	  else
    		  var td=$("<td width=\"18%\">"+i*j+"</td>");
         td.appendTo(tr);
      }
   }
   trend.appendTo(table);
   $("#information").append("</table>");
}