package wiki.common_cat.sourceService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;
import wiki.common_cat.sourceService.entities.Music;
import wiki.common_cat.sourceService.mapper.SourceMapper;
import wiki.common_cat.sourceService.service.SourceService;
import wiki.common_cat.sourceService.service.TokenService;

import java.util.Date;
import java.util.Random;

public class CommonSourceService implements SourceService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SourceMapper sourceMapper;
    @Override
    public void deleteDoc(String token) {
        String id= tokenService.getID(token);
        if(id==null){
            return;
        }
        sourceMapper.deleteDoc(id);
    }

    @Override
    public String getDoc(String id) {
        return (new Gson()).toJson(sourceMapper.getDoc(id));
    }

    @Override
    public void setDoc(String token,String html) {
        String id= tokenService.getID(token);
        if(id==null){
            return;
        }
        Doc doc=new Doc();
        doc.setDate((new Date()).toString());
        doc.setAuthorID(id);
        doc.setStatus(Doc.WAITING_FOR_AUDIT);
        doc.setHTML(html);
        sourceMapper.setDoc(id,doc);
    }

    @Override
    public String setMusic(String token, String base64) {
        String id= tokenService.getID(token);
        if(id==null){
            return "err";
        }
        Music music=new Music();
        music.setMusicID(String.valueOf((new Random()).nextFloat())+String.valueOf(base64.hashCode()));
        music.setBase64(base64);
        music.setDate((new Date()).toString());
        sourceMapper.setMusic(id,music);
        return music.getMusicID();
    }

    @Override
    public String getMusic(String id, String musicID) {
        return (new Gson()).toJson(sourceMapper.getMusic(id,musicID));
    }

    @Override
    public String setImage(String token, String base64) {
        String id= tokenService.getID(token);
        if(id==null){
            return "err";
        }
        Image image=new Image();
        image.setImageID(String.valueOf((new Random()).nextFloat())+String.valueOf(base64.hashCode()));
        image.setBase64(base64);
        image.setDate((new Date()).toString());
        sourceMapper.setImage(id,image);
        return image.getImageID();
    }

    @Override
    public String getImage(String id, String imageID) {
        return (new Gson()).toJson(sourceMapper.getImage(id,imageID));
    }

    @Override
    public void deleteMusic(String id, String musicID) {
        sourceMapper.deleteMusic(id,musicID);
    }

    @Override
    public void deleteImage(String id, String imageID) {
        sourceMapper.deleteImage(id,imageID);
    }

}
