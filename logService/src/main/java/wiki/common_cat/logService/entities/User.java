package wiki.common_cat.logService.entities;

public class User {
    private int id;
    private String date;
    private int salt;
    private int pwdhash;
    private long lastLoginDate;
    public static final long muchTimes=1000000000*1000;
    public static final long releaseTime=1000000000*24*3600;
    public static final int muchTryTimes=5;
    public static final int LOCKED=1,COMMON=0;
    private int status;
    private int loginTimes;

    public long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(int loginTimes) {
        this.loginTimes = loginTimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public int getPwdhash() {
        return pwdhash;
    }

    public void setPwdhash(int pwdhash) {
        this.pwdhash = pwdhash;
    }
    public boolean tryRightTimes(){
        if(loginTimes==0){
            lastLoginDate=System.nanoTime();
        }
        if(loginTimes>muchTryTimes){
            status=LOCKED;
        }
        if(status==LOCKED){
            if((System.nanoTime()-lastLoginDate)>releaseTime){
                loginTimes=0;
                status=COMMON;
                return true;
            }
            return false;
        }else {
            if((System.nanoTime()-lastLoginDate)>releaseTime){
                loginTimes=0;
                return true;
            }
        }
        loginTimes++;
        return true;
    }

    public boolean isRightPWD(String pwd){
        int hash_=(pwd+getSalt()).hashCode();
        return hash_==getPwdhash();
    }
    public String toString(){
        return "id:"+id+"\npwdhash:"+pwdhash+"\nsalt:"+salt;
    }
}
