package wiki.common_cat.sourceService.entities;

public class Image {

    public String imageID;
    //名称
    public byte[] file;
    //内容
    public String date;
    //提交日期


    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
