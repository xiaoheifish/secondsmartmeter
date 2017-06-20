var totalmoney = "0";
function changeTen(){
    totalmoney = "10";
}
function changeTwenty(){
    totalmoney = "20";
}
function changeThirty(){
    totalmoney = "30";
}
function changeFifty(){
    totalmoney = "50";
}
function changeHundred(){
    totalmoney = "100";
}
function changeTwoHund(){
    totalmoney = "200";
}
function changeNull(){
    totalmoney = "0";
}
function showTip(tipTxt) {
    var div = document.createElement('p');
    div.innerHTML = '<p class="labelmessage">' + tipTxt + '</p>';
    var tipNode = div.firstChild;
    $("#showmessage").after(tipNode);
    setTimeout(function () {
        $(tipNode).remove();
    }, 1500);
}
function onSubmit(){
    if (totalmoney == "10"){
        location.href ='/billcheck?money=10';
        return;
    }
    else if (totalmoney == "20"){
        location.href ='/billcheck?money=20';
        return;
    }
    else if (totalmoney == "30"){
        location.href ='/billcheck?money=30';
        return;
    }
    else if (totalmoney == "50"){
        location.href ='/billcheck?money=50';
        return;
    }
    else if (totalmoney == "100"){
        location.href ='/billcheck?money=100';
        return;
    }
    else if (totalmoney == "200"){
        location.href ='billcheck?money=200';
        return;
    }
    else{
        var money = $("#inputmoney").val();
        var patrn = /^(-)?\d+(\.\d+)?$/;
        var re = /^[0-9]+$/ ;
        if (!patrn.exec($.trim(money))) {
            showTip('请输入数字')
        }
        else if(!re.exec($.trim(money))){
            showTip('请输入正整数')
        }
        else if(money < 1 || money > 200){
            showTip('金额需在1-200之间')
        }
        else{
            location.href ='/billcheck?money=' + money.toString();
            return;
        }
    }
}
