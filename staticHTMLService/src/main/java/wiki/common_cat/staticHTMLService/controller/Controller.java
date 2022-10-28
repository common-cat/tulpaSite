package wiki.common_cat.staticHTMLService.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/static/search")
    public ModelAndView search(HttpServletRequest httpServletRequest){
        String q=httpServletRequest.getParameter("q");
        ModelAndView modelAndView=new ModelAndView("searchPage");
        modelAndView.addObject("q",q);
        return modelAndView;
    }
    @GetMapping("/")
    public String main(){
        return "mainPage";
    }

    @GetMapping("/static/signin")
    public String signIn(){
        return "signPage";
    }
    @GetMapping("/static/login")
    public String loginIn(){
        return "loginPage";
    }
    @GetMapping("/static/create")
    public String create(){return "create";}
}
