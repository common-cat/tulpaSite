package wiki.common_cat.sourceService.entities;

public class Doc {
    public static final int WAITING_FOR_AUDIT=-1,AUDITING=-2,AUDIT_REJECT=0,AUDIT_ACCEPT=1,DELETED=2;
    //文档状态码
    public String HTML;
    //文章内容
    public int authorID;
    //作者ID
    public String date;
    //提交日期



    public String getHTML() {
        return HTML;
    }

    public void setHTML(String HTML) {
        this.HTML = HTML;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

public String toString(){
        return "HTML:"+HTML;
}

}
