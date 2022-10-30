package wiki.common_cat.tokenService.entities;

public class User {
    private String id;
    private String date;
    private int salt;
    private int pwdhash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isRightPWD(String pwd){
        int hash_=(pwd+getSalt()).hashCode();
        return hash_==getPwdhash();
    }
}
