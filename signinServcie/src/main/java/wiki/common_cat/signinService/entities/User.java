package wiki.common_cat.signinService.entities;

public class User {
    private String date;
    private int salt;
    private int pwdhash;

    private String email;
    private String tulpas;
    private String hosts;

    public String getTulpas() {
        return tulpas;
    }

    public void setTulpas(String tulpas) {
        this.tulpas = tulpas;
    }

    public String getHosts() {
        return hosts;
    }

    public void setHosts(String hosts) {
        this.hosts = hosts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
