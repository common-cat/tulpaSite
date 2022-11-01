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
    public void deleteDoc(String token) {
        String id="0";
        sourceMapper.deleteDoc(id);
    }

    @Override
    public String getDoc(String id,String sessionID) {
        String realID="";
        try{
            realID=jedis.get(sessionID);
        }catch (Exception e){

        }
        Doc doc=sourceMapper.getDoc(id);
        try{
        if(realID.equals(id)||((sourceMapper.isAdmin(realID)!=null))||doc.status==Doc.AUDIT_ACCEPT){
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
        if(sourceMapper.docExist(id)==null){
            sourceMapper.setDoc(html,id,(new Date()).toString(), Doc.WAITING_FOR_AUDIT);
        }else {
            sourceMapper.updateDoc(html,id,(new Date()).toString(), Doc.WAITING_FOR_AUDIT);
        }
    }
    @Override
    public String setImage( String base64,String sessionID) {
        String id=jedis.get(sessionID);
        String imageID;
        String flag=sourceMapper.imageExist(base64.hashCode());
        if(flag==null){
            imageID=id+"-"+System.nanoTime()+(new Random()).nextFloat();
            sourceMapper.setImage(imageID, Base64.getDecoder().decode(base64.replaceAll(" ","+")),(new Date()).toString(),base64.hashCode());
        }else {
            imageID=flag;
        }
        return "/source/image/"+imageID;
    }

    @Override
    public byte[] getImage(String imageID) {
        return sourceMapper.getImage(imageID).getFile();
    }


    @Override
    public void deleteImage(String id, String imageID) {
        sourceMapper.deleteImage(id,imageID);
    }
    public String completeDOC(String sessionID){
        String id=jedis.get(sessionID);
        sourceMapper.completeDOC(id);
        return "";
    }

    @Override
    public String getAuditedDoc(String id) {
        return sourceMapper.getAuditedDoc(id);
    }
}
