function getCookie(name) {
    var arr = document.cookie.match(new RegExp(name + "=\\w+;?", "g"));
    if (arr != null) {
        return arr[0].split("=")[1].replace(";","");
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
function getID(){
    return getCookie("id");
}
function setID(id){
    setCookie("id",id);
}