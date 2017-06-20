var querytime = "0";
function threeMonth(){
    querytime = "3";
}
function sixMonth(){
    querytime = "6";
}
function oneYear(){
    querytime = "12";

}
function thisYear(){
    querytime = "2017";
}
function lastYear(){
    querytime = "2016";
}
function showTip(tipTxt) {
    document.getElementById("showmessage").innerHTML="<p class = 'label1' id = 'showmessage' ><font color=rgb(39,39,39)>请选择查询条件</font></p>";
    setTimeout(function () {
        document.getElementById("showmessage").innerHTML="<p class = 'label1' id = 'showmessage' ><font color='white'>请选择查询条件</font></p>";
    }, 1000);
}
function onSubmit(){
    if (querytime == "3"){
        querytime = "0";
        location.href ='/showgraph?querytime=3';
        return;

    }
    else if (querytime == "6"){
        querytime = "0";
        location.href ='/showgraph?querytime=6';
        return;
    }
    else if (querytime == "12"){
        querytime = "0";
        location.href ='/showgraph?querytime=12';
        return;
    }
    else if (querytime == "2016"){
        querytime = "0";
        location.href ='/showgraph?querytime=2016';
        return;
    }
    else if (querytime == "2017"){
        querytime = "0";
        location.href ='/showgraph?querytime=2017';
        return;
    }
    else{
        showTip("请选择查询条件");
    }
}
