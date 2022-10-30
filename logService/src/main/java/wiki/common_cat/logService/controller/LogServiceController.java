package wiki.common_cat.logService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.logService.service.LogService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
public class LogServiceController {
    @Resource(name = "commonLogService")
    private LogService logService;
    @PostMapping("/login/id")
    public String loginByID(HttpServletRequest request){
        String id=request.getParameter("id");
        String pwd=request.getParameter("pwd");
        return logService.logByID(id,pwd);
    }
    @PostMapping("/login/email")
    public String loginByEmail(HttpServletRequest request){
        String email=request.getParameter("email");
        String pwd=request.getParameter("pwd");
        return logService.logByEmail(email,pwd);
    }
}
