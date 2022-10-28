package wiki.editService.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ImageResponse implements Serializable {
    public int errno=0;
    public Map<String,String> data=new HashMap<>();
    public void setURL(String url){
        data.put("url",url);
    }
    public void setAlt(String alt){data.put("alt",alt);}
}
