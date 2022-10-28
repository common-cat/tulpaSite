package wiki.common_cat.sourceService.entities;

public class Image {

    public String imageID;
    //名称
    public String base64;
    //内容
    public String date;
    //提交日期


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
