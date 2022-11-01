package wiki.common_cat.privatePageService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.privatePageService.service.PrivatePageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class PrivatePageController {
    @Resource(name = "commonPrivatePageService")
    private PrivatePageService privatePageService;
    @GetMapping("/private/userinfo/{id}")
    public String getUserInfo(@PathVariable("id") String id){
        return privatePageService.getUserInfo(id);
    }
    @PostMapping("/private/setuserinfo")
    public void setUserInfo(HttpServletRequest request){
        privatePageService.setUserInfo(request.getParameter("sessionID"),request.getParameter("tulpas"),request.getParameter("hosts"),request.getParameter("introduction"));
    }
}
