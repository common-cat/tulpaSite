package wiki.common_cat.auditService.entities;

public class Doc {
    //文档状态码
    public String HTML;
    //文章内容
    public int authorID;
    //作者ID
    public String date;
    //提交日期
    //状态码

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


}
