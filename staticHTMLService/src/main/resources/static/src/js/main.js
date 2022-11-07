function getCookie(name) {
    var arr = document.cookie.match(new RegExp(name + "=\\w+;?", "g"));
    if (arr != null) {
        return arr[0].split("=")[1].replace(";", "");
    }
    return null;
}
function setCookie(name, value) {
    document.cookie = name + "=" + value;
}
function delCookie(name) {
    document.cookie = name + "=";
}
function setSessionID(id) {
    setCookie("sessionID", id);
}
function getSessionID() {
    return getCookie("sessionID");
}
function getID() {
    return getCookie("id");
}
function setID(id) {
    setCookie("id", id);
}

function isPhone() {
    //获取浏览器navigator对象的userAgent属性（浏览器用于HTTP请求的用户代理头的值）
    var info = navigator.userAgent;
    //通过正则表达式的test方法判断是否包含“Mobile”字符串
    var isPhone = /mobile/i.test(info);
    //如果包含“Mobile”（是手机设备）则返回true
    return isPhone;
}

function loadStyle(url) {
    var link = document.createElement('link');
    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = url;
    var head = document.getElementsByTagName('head')[0];
    head.appendChild(link);
}