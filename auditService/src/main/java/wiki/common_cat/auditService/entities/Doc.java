package wiki.common_cat.auditService.entities;

public class Doc {
    //文档状态
    // 码
    public String HTML;
    //文章内容
    public int id;
    //作者ID
    public String date;
    //提交日期
    //状态码

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

    public String getHTML() {
        return HTML;
    }

    public void setHTML(String HTML) {
        this.HTML = HTML;
    }
}
