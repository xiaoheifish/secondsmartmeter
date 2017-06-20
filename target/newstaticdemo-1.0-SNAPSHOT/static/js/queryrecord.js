
function Init(){
    var jsonstr;
    $.ajax({
        type:'GET',
        url:'/getTotalPayment',
        data: {
        },
        dataType: 'json',
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
        },
        success:function(data){
            jsonstr = data;
            var tabVar="";
            var map = new Object();
            for (var i = 0; i < jsonstr.length; i++){
                var item = jsonstr[i];
                var time = item.timestamp.split(' ')[0];
                time = time.substring(0,7);
                if(!map[time]){
                    var array = new Array();
                    array.push(item);
                    map[time] = {time:time,money:parseInt(item.money),number:1};
                }
                else{
                    var temp = map[time];
                    temp.money += parseInt(item.money);
                    temp.number += 1;
                    map[time] = temp;
                }
            }
            var record = 0;
            for(var key in map){
                tabVar += "<thead><tr class ='main'><th>" + (map[key].time).substring(0,4) + "年" + (map[key].time).substring(5,7)+"月：</th><th></th><th class ='tmoney'>"+ map[key].money + "元</th></tr></thead>";
                tabVar += "<tbody>";
                for(var k =0;k<map[key].number;k++){
                    tabVar += "<tr class = 'data'><td>"+ jsonstr[k+record]["timestamp"].substring(0,10)+ "</td><td>" + jsonstr[k+record]["timestamp"].substring(11,19) + "</td><td class = 'money'>"+ jsonstr[k+record]["money"] +"元</td></tr>";
                }
                tabVar += "</tbody>"
                record = record + map[key].number;
            }
            document.getElementById("mytable").innerHTML=tabVar;

        }
    });

}