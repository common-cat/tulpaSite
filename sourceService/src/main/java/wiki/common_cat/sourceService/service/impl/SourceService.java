package wiki.common_cat.sourceService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import org.springframework.stereotype.Service;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.mapper.SourceMapper;

import java.util.Base64;
import java.util.Date;
import java.util.Random;
@Service("testSourceService")
public class SourceService implements wiki.common_cat.sourceService.service.SourceService {
    private Jedis jedis=new Jedis("localhost");
    @Autowired
    private SourceMapper sourceMapper;
    @Override
    public void deleteDoc(String sessionID) {
        String id=jedis.get(sessionID);
        sourceMapper.deleteDoc(Integer.valueOf(id));
    }

    @Override
    public String getDoc(String id,String sessionID) {
        String realID="";
        try{
            realID=jedis.get(sessionID);
        }catch (Exception e){
        }
        Doc doc=sourceMapper.getDoc(Integer.parseInt(realID));
        try{
        if(realID.equals(id)||((sourceMapper.isAdmin(Integer.valueOf(realID))!=null))){
            return (new Gson()).toJson(doc);
        }
        }catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    @Override
    public void setDoc(String html,String sessionID) {
        String id=jedis.get(sessionID);
        if(sourceMapper.docExist(Integer.valueOf(id))==null){
            sourceMapper.setDoc(html,Integer.valueOf(id));
        }else {
            sourceMapper.updateDoc(html,Integer.valueOf(id));
        }
    }
    @Override
    public String setImage(String base64,String sessionID) {
        String id=jedis.get(sessionID);
        String imageID;
        String flag=sourceMapper.imageExist(id+"img",base64.hashCode());
        if(flag==null){
            sourceMapper.setImage(id+"img", Base64.getDecoder().decode(base64.replaceAll(" ","+")),base64.hashCode());
            imageID=id+"-"+sourceMapper.getImageID();
        }else {
            imageID=flag;
        }
        return "/source/image/"+id+"-"+imageID;
    }

    @Override
    public byte[] getImage(String imageID) {

        return sourceMapper.getImage(imageID.split("-")[0]+"img",Integer.valueOf(imageID.split("-")[1])).getFile();
    }


    @Override
    public void deleteImage(String id, String imageID) {

    }


    @Override
    public String getAuditedDoc(String id) {
        return sourceMapper.getAuditedDoc(Integer.valueOf(id));
    }
}
