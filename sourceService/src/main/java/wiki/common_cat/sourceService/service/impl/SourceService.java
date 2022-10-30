package wiki.common_cat.sourceService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;
import wiki.common_cat.sourceService.mapper.SourceMapper;
import wiki.common_cat.sourceService.service.SourceService;
import wiki.common_cat.sourceService.service.TokenService;

import java.io.File;
import java.util.Base64;
import java.util.Date;
import java.util.Random;
@Service("testSourceService")
public class TestSourceService implements SourceService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SourceMapper sourceMapper;
    @Override
    public void deleteDoc(String token) {
        String id="0";
        sourceMapper.deleteDoc(id);
    }

    @Override
    public String getDoc(String id) {
        return (new Gson()).toJson(sourceMapper.getDoc(id));
    }

    @Override
    public void setDoc(String token,String html) {
        String id="0";
        sourceMapper.setDoc(html,id,(new Date()).toString(), Doc.WAITING_FOR_AUDIT);
    }
    @Override
    public String setImage(String token, String base64) {
        String id="0";
        String imageID;
        String flag=sourceMapper.imageExist(base64.hashCode())[0];
        if(flag=="null"){
            imageID=id+"-"+System.nanoTime()+(new Random()).nextFloat();
            sourceMapper.setImage(imageID, Base64.getDecoder().decode(base64.replaceAll(" ","+")),(new Date()).toString(),base64.hashCode());
        }else {
            imageID=flag;
        }
        return "/source/image/"+imageID;
    }

    @Override
    public byte[] getImage(String imageID) {
        String table=imageID.split("-")[1];
        return sourceMapper.getImage(imageID).getFile();
    }


    @Override
    public void deleteImage(String id, String imageID) {
        sourceMapper.deleteImage(id,imageID);
    }

}
