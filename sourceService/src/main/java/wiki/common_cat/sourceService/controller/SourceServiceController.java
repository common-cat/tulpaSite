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
    @GetMapping("/source/doc_mew/{id}")
    public String getAuditedDoc(@PathVariable("id")String id){
        return sourceService.getAuditedDoc(id);
    }
    @GetMapping("/source/doc/{id}")
    public String getDoc(HttpServletRequest httpServletRequest,@PathVariable("id")String id){
        String sessionID=httpServletRequest.getParameter("sessionID");
        System.out.println(sourceService.getDoc(id,sessionID));
        return sourceService.getDoc(id,sessionID);
    }
    //根据用户ID获取其花名册 每个用户维护一份自己的DOC
    @PostMapping("/source/del-doc")
    public void deleteDoc(HttpServletRequest httpServletRequest){
        String sessionID=httpServletRequest.getParameter("sessionID");
        sourceService.deleteDoc(sessionID);
    }
    @PostMapping("/source/upload-doc")
    public void setDoc(HttpServletRequest httpServletRequest){
        String sessionID=httpServletRequest.getParameter("sessionID");
        sourceService.setDoc(httpServletRequest.getParameter("html"),sessionID);
    }
    @PostMapping("/source/upload-image")
    public String setImage(HttpServletRequest httpServletRequest){
        String sessionID=httpServletRequest.getParameter("sessionID");
        String base64=httpServletRequest.getParameter("image");
        return sourceService.setImage(base64,sessionID);
    }
    @GetMapping("/source/image/{imageID}")
    public byte[] getImage(@PathVariable("imageID")String imageID){
        return sourceService.getImage(imageID);
    }
    @PostMapping("/source/del-image/{id}/{imageID}")
    public void deleteImage(HttpServletRequest httpServletRequest,@PathVariable("musicID")String imageID){
        sourceService.deleteImage(httpServletRequest.getParameter("sessionID"),imageID);
    }
    @PostMapping("/source/complete_doc")
    public String completeDOC(HttpServletRequest httpServletRequest){
        return sourceService.completeDOC(httpServletRequest.getSession().getId());
    }
}
