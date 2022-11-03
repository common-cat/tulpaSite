package wiki.common_cat.staticHTMLService.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wiki.common_cat.staticHTMLService.service.StaticHTMLService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {
    @Resource(name = "commonStaticHTMLService")
    private StaticHTMLService service;
    @GetMapping("/static/search")
    public String search(HttpServletRequest httpServletRequest,Model model){
        model.addAttribute("q",httpServletRequest.getParameter("q"));
        return "searchPage";
    }
    @GetMapping("/static/main")
    public String main(){
        return "mainPage";
    }

    @GetMapping("/static/signin")
    public String signIn(){
        return "signinPage";
    }
    @GetMapping("/static/login")
    public String loginIn(){
        return "loginPage";
    }
    @GetMapping("/static/create")
    public String create(){return "create";}
    @GetMapping("/static/private/{id}")
    public String privatePage(@PathVariable("id")String id,Model model){
        model.addAttribute("title",id+"的页面");
        return "privatePage";
    }
    @GetMapping("/static/audit")
    public String audit(){
        return "auditPage";
    }
}
