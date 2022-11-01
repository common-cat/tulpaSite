package wiki.common_cat.mainPageService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.mainPageService.service.MainPageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MainPageServiceController {
    @Resource(name = "commonMainPageService")
    private MainPageService mainPageService;
    @GetMapping("/mainpage/random/{pages}")
    public String randomPages(@PathVariable("pages")int pages){
        return mainPageService.randomPages(pages);
        //TODO
    }
    //获取机页面
}
