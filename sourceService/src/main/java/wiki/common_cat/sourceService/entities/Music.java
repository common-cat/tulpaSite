package wiki.common_cat.sourceService.entities;

public class Music {
    public String musicID;
    //MusicID
    public String name;
    //名称
    public String base64;
    //内容
    public String date;
    //提交日期


    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
