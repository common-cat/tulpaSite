//这个文件用户用户登录 存储登陆状态 以及cookie
//var sessionId=document.cookie.
var failedFun;
var nullFun;
var readyFun;
function getAjax() {
    var ajax = new XMLHttpRequest("POST", window.location.host + "/login");
    return ajax;
}
function ready(ajax){
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4) {
            if (ajax.status == 200) {
                let text=ajax.responseText;
                if(text=="null"){
                    nullFun();
                    return;
                }else if(test=="false"){
                    failedFun(message);
                    return;
                }
                let user=JSON.parse(text);
                readyFun(user);
            }
        }
    }
}
function registe(failedFun_,nullFun_,readyFun_){
    failedFun=failedFun_;
    nullFun=nullFun_;
    readyFun=readyFun_;
}
//注册函数
//收到返回数据
function loginbyID(userid, pwd) {
    ajax.send("user="+userid+"&pwd="+pwd+"&method="+"id");
    ready(ajax);
}
//根据ID登录
function loginbyEmail(email, pwd) {
    ajax.send("user="+email+"&pwd="+pwd+"&method=email");
    ready(ajax);
}
//根据电子邮箱登录
function loginbyName(name, pwd) {
    ajax.send("user="+name+"&pwd="+pwd+"&method=name");
    ready(ajax);
}
//根据用户名登录
function loginbyToken(token){
    try{
        if(token==""){
            document.getElementById("logout").click();
        }else{
            ajax.send("token="+token+"&method=token");
        }
    }catch(e){
        
    }

}