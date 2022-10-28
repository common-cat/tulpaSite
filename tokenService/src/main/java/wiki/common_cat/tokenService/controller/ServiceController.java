package wiki.common_cat.tokenService.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.tokenService.service.TokenMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class ServiceController {
    @Resource(name = "commonTokenMap")
    private TokenMap tokenMap;
    //对外暴露的服务控制器 用户进行token的服务
    @PostMapping("/token/gettoken")
    public String getToken(HttpServletRequest httpServletRequest){
        String id= httpServletRequest.getParameter("id");
        String pwd=httpServletRequest.getParameter("pwd");
        String isAccountNonExpired=httpServletRequest.getParameter("isAccountNonExpired");
        return tokenMap.getToken(id,pwd,Boolean.valueOf(isAccountNonExpired));
    }
    @PostMapping("/token/updateToken/{token}")
    public void updateToken(@PathVariable("token")String token){
        tokenMap.updateToken(token);
    }
    //刷新token销毁时间
    @GetMapping("/token/getid/{token}")
    public String getID(@PathVariable("token")String token){
        return tokenMap.getID(token);
    }
    //根据token获取ID 如果不存在 则返回保留ID: 0
}
