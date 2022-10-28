package wiki.common_cat.sourceService.controller;

import com.google.gson.Gson;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.sourceService.entities.Doc;
import wiki.common_cat.sourceService.entities.Image;
import wiki.common_cat.sourceService.entities.Music;
import wiki.common_cat.sourceService.mapper.SourceMapper;
import wiki.common_cat.sourceService.service.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

@RestController
public class SourceServiceController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private SourceMapper sourceMapper;
    @GetMapping("/source/doc/{id}")
    public String getDoc(@PathVariable("id")String id){
        return (new Gson()).toJson(sourceMapper.getDoc(id));
    }
    //根据用户ID获取其花名册 每个用户维护一份自己的DOC
    @PostMapping("/source/del-doc")
    public void deleteDoc(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String id= tokenService.getID(token);
        if(id==null){
            return;
        }
        sourceMapper.deleteDoc(id);
    }
    @PostMapping("/source/upload-doc")
    public void setDoc(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String id= tokenService.getID(token);
        if(id==null){
            return;
        }
        Doc doc=new Doc();
        doc.setDate((new Date()).toString());
        doc.setAuthorID(id);
        doc.setStatus(Doc.WAITING_FOR_AUDIT);
        doc.setHTML(httpServletRequest.getParameter("html"));
        sourceMapper.setDoc(id,doc);
    }
    @PostMapping("/source/upload-music")
    public String setMusic(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String id= tokenService.getID(token);
        if(id==null){
            return "err";
        }
        Music music=new Music();
        String base64=httpServletRequest.getParameter("music");
        music.setMusicID(String.valueOf((new Random()).nextFloat())+String.valueOf(base64.hashCode()));
        music.setBase64(base64);
        music.setDate((new Date()).toString());
        sourceMapper.setMusic(id,music);
        return music.getMusicID();
    }
    @GetMapping("/source/music/{id}/{musicID}")
    public String getMusic(@PathVariable("id")String id,@PathVariable("musicID")String musicID){
        return (new Gson()).toJson(sourceMapper.getMusic(id,musicID));
    }
    @PostMapping("/source/upload-image")
    public String setImage(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String id= tokenService.getID(token);
        if(id==null){
            return "err";
        }
        Image image=new Image();
        String base64=httpServletRequest.getParameter("image");
        image.setImageID(String.valueOf((new Random()).nextFloat())+String.valueOf(base64.hashCode()));
        image.setBase64(base64);
        image.setDate((new Date()).toString());
        sourceMapper.setImage(id,image);
        return image.getImageID();
    }
    @GetMapping("/source/image/{id}/{imageID}")
    public String getImage(@PathVariable("id")String id,@PathVariable("imageID")String imageID){
        return (new Gson()).toJson(sourceMapper.getImage(id,imageID));
    }
    @PostMapping("/source/del-music/{id}/{musicID}")
    public void deleteMusic(@PathVariable("id")String id,@PathVariable("imageID")String musicID){
        sourceMapper.deleteMusic(id,musicID);
    }
    @PostMapping("/source/del-image/{id}/{imageID}")
    public void deleteImage(@PathVariable("id")String id,@PathVariable("musicID")String imageID){
        sourceMapper.deleteImage(id,imageID);
    }

}
