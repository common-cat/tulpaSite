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
import wiki.common_cat.sourceService.service.SourceService;
import wiki.common_cat.sourceService.service.TokenService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Random;

@RestController
public class SourceServiceController {
    @Resource(name = "commonSourceService")
    private SourceService sourceService;

    @GetMapping("/source/doc/{id}")
    public String getDoc(@PathVariable("id")String id){
        return sourceService.getDoc(id);
    }
    //根据用户ID获取其花名册 每个用户维护一份自己的DOC
    @PostMapping("/source/del-doc")
    public void deleteDoc(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        sourceService.deleteDoc(token);
    }
    @PostMapping("/source/upload-doc")
    public void setDoc(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        sourceService.setDoc(token,httpServletRequest.getParameter("html"));
    }
    @PostMapping("/source/upload-music")
    public String setMusic(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String base64=httpServletRequest.getParameter("music");
        return sourceService.setMusic(token,base64);
    }
    @GetMapping("/source/music/{id}/{musicID}")
    public String getMusic(@PathVariable("id")String id,@PathVariable("musicID")String musicID){
        return sourceService.getMusic(id,musicID);
    }
    @PostMapping("/source/upload-image")
    public String setImage(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String base64=httpServletRequest.getParameter("image");
        return sourceService.setImage(token,base64);
    }
    @GetMapping("/source/image/{id}/{imageID}")
    public String getImage(@PathVariable("id")String id,@PathVariable("imageID")String imageID){
        return sourceService.getImage(id,imageID);
    }
    @PostMapping("/source/del-music/{id}/{musicID}")
    public void deleteMusic(@PathVariable("id")String id,@PathVariable("imageID")String musicID){
        sourceService.deleteMusic(id,musicID);
    }
    @PostMapping("/source/del-image/{id}/{imageID}")
    public void deleteImage(@PathVariable("id")String id,@PathVariable("musicID")String imageID){
        sourceService.deleteImage(id,imageID);
    }

}
