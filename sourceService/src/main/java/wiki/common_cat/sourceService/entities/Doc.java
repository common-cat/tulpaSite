package wiki.common_cat.sourceService.entities;

public class Doc {
    public static final int WAITING_FOR_AUDIT=-1,AUDITING=-2,AUDIT_REJECT=0,AUDIT_ACCEPT=1,DELETED=2;
    //文档状态码
    public String HTML;
    //文章内容
    public String authorID;
    //作者ID
    public String date;
    //提交日期
    public int status;
    //状态码

    public String getHTML() {
        return HTML;
    }

    public void setHTML(String HTML) {
        this.HTML = HTML;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
