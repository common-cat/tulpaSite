package wiki.common_cat.sourceService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.sourceService.service.SourceService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class SourceServiceController {
    @Resource(name = "testSourceService")
    private SourceService sourceService;

    @GetMapping("/source/doc/{id}")
    public String getDoc(HttpServletRequest httpServletRequest){
        String id=httpServletRequest.getParameter("id");
        String token=httpServletRequest.getParameter("token");
        return sourceService.getDoc(id,token);
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
    @PostMapping("/source/upload-image")
    public String setImage(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getParameter("token");
        String base64=httpServletRequest.getParameter("image");
        return sourceService.setImage(token,base64);
    }
    @GetMapping("/source/image/{imageID}")
    public byte[] getImage(@PathVariable("imageID")String imageID){
        return sourceService.getImage(imageID);
    }
    @PostMapping("/source/del-image/{id}/{imageID}")
    public void deleteImage(@PathVariable("id")String id,@PathVariable("musicID")String imageID){
        sourceService.deleteImage(id,imageID);
    }
    @PostMapping("/source/complete_doc")
    public String completeDOC(HttpServletRequest httpServletRequest){
        return sourceService.completeDOC(httpServletRequest.getParameter("token"));
    }
}
