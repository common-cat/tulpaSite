package wiki.common_cat.logService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        String id=request.getParameter("user");
        String pwd=request.getParameter("pwd");
        return logService.logByID(request.getSession().getId(),id,pwd);
    }
    @PostMapping("/login/email")
    public String loginByEmail(HttpServletRequest request) {
        String id = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        return logService.logByID(request.getSession().getId(), id, pwd);
    }
    @PostMapping("/login/sessionID")
    public String sessionID(HttpServletRequest request){
        return logService.sessionID(request.getParameter("sessionID"));
    }
}
