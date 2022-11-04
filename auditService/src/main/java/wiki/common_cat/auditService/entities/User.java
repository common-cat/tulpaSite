package wiki.common_cat.auditService.entities;


public class User {
    private String ID;
    private String tulpas;
    private String hosts;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    private String introduction;
    public String toString(){
        return "id:"+ID+" tulpas:"+tulpas;
    }
}
