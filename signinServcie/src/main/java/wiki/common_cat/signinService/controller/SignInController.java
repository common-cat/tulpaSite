package wiki.common_cat.signinService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.signinService.service.SignInService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@RestController
public class SignInController {
    @Resource(name = "commonSigninService")
    private SignInService service;
    @PostMapping("/signin/commit/")
    public String commit(HttpServletRequest request){
        return service.signIn(request.getParameter("email"),request.getParameter("date"),request.getParameter("pwd"),request.getParameter("tulpas"),request.getParameter("hosts"));
    }
}
