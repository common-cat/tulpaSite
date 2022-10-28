function getCookie(name) {
    var arr =document.cookie.match(new RegExp(name+"=\\w+;?","g"));
    if(arr != null) {
        return arr[0].split("=")[1];
    }
    return null;
}
function setCookie(name,value){
    document.cookie=name+"="+value;
}
function delCookie(name){
    document.cookie=name+"=";
}