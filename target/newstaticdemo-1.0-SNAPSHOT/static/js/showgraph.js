var flag = true;
var list1 = [];
var list2 = [];
var tabVar="";
var map = new Object();

function Init() {
    $.ajax({
        type:'POST',
        url:'/getTotalElectricity',
        data: {
            "timespan":timeSpan
        },
        dataType: 'json',
        error: function(XMLHttpRequest, textStatus, errorThrown){
            alert(XMLHttpRequest.status);
        },
        success:function(data){
            var jsonstr = data;

            for (var i = 0; i < jsonstr.length; i++){
                var item = jsonstr[i];
                var time = item.time.split(' ')[0];
                time = time.substring(0,7);
                if(!map[time]){
                    var array = new Array();
                    array.push(item);
                    map[time] = {time:time,electricity:parseInt(item.electricity),number:1};
                }
                else{
                    var temp = map[time];
                    temp.electricity += parseInt(item.electricity);
                    temp.number += 1;
                    map[time] = temp;
                }
            }
            var record = 0;
            tabVar += "<table class='table moveleft'>";
            for(var key in map){
                var id = map[key].time.substring(0,7);
                var idbody = id+"body";
                tabVar += "<thead><tr class ='main' id = "+ id +"><th>" + (map[key].time).substring(0,4) + "年" + (map[key].time).substring(5,7)+"月：</th><th></th><th class ='tmoney'>"+ map[key].electricity + "度</th></tr></thead>";
                if(record == 0){
                    tabVar += "<tbody id="+ idbody +">";
                }
                else{
                    tabVar += "<tbody id="+ idbody +" >";
                }
                for(var k =0;k<map[key].number;k++){
                    tabVar += "<tr class = 'data'><td>"+ jsonstr[k+record]["time"].substring(0,10)+ "</td><td>" + "</td><td class = 'money'>"+ jsonstr[k+record]["electricity"] +"度</td></tr>";
                    list1.push(jsonstr[k+record]["time"].substring(0,10));
                    list2.push(jsonstr[k+record]["electricity"]);
                }
                tabVar += "</tbody>"
                record = record + map[key].number;
            }
            tabVar += "</table>";
            document.getElementById("main").innerHTML=tabVar;

        }
    });
}

function change() {
    flag = !flag;
    if(flag){
        var obj = document.getElementById("flipline");
        obj.style.cssText = "margin-bottom:3.5%";
        document.getElementById("changetable").innerHTML="切换为图表";
        document.getElementById("main").innerHTML=tabVar;
    }
    else{
        document.getElementById("changetable").innerHTML="切换为数据";
        var obj = document.getElementById("flipline");
        obj.style.cssText = "margin-bottom:1%";
        var myChart = echarts.init(document.getElementById('main'));
        option = {
            tooltip : {
                trigger: 'axis'
            },
            toolbox: {
                show : true,
                feature : {
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true,}
                },
                itemSize:24,
            },
            calculable : true,
            dataZoom : {
                show : true,
                realtime : true,
                start : 20,
                end : 80
            },
            xAxis : [
                {
                    type : 'category',
                    boundaryGap : false,
                    data : list1
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'电量',
                    type:'line',
                    itemStyle:{
                        normal:{
                            color:'#66CDAA',
                            lineStyle:{
                                color:'#66CDAA',
                                width:3
                            }
                        }
                    },
                    data:list2
                },
            ]
        };
        myChart.setOption(option);
    }
}

$("#2016-01").click(function(){
    $("#2016-01body").toggle();
});
$("#2016-02").click(function(){
    $("#2016-02body").toggle();
});
$("#2016-03").click(function(){
    $("#2016-03body").toggle();
});
$("#2016-04").click(function(){
    $("#2016-04body").toggle();
});
$("#2016-05").click(function(){
    $("#2016-05body").toggle();
});
$("#2016-06").click(function(){
    $("#2016-06body").toggle();
});
$("#2016-07").click(function(){
    $("#2016-07body").toggle();
});
$("#2016-08").click(function(){
    $("#2016-08body").toggle();
});
$("#2016-09").click(function(){
    $("#2016-09body").toggle();
});
$("#2016-10").click(function(){
    $("#2016-10body").toggle();
});
$("#2016-11").click(function(){
    $("#2016-11body").toggle();
});
$("#2016-12").click(function(){
    $("#2016-12body").toggle();
});
$("#2017-01").click(function(){
    $("#2017-01body").toggle();
});
$("#2017-02").click(function(){
    $("#2017-02body").toggle();
});
$("#2017-03").click(function(){
    $("#2017-03body").toggle();
});
$("#2017-04").click(function(){
    $("#2017-04body").toggle();
});
$("#2017-05").click(function(){
    $("#2017-05body").toggle();
});
$("#2017-06").click(function(){
    $("#2017-06body").toggle();
});

