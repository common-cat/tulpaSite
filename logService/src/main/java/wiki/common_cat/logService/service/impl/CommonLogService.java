package wiki.common_cat.logService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.common_cat.logService.entities.User;
import wiki.common_cat.logService.mapper.LogMapper;
import wiki.common_cat.logService.service.LogService;
import wiki.common_cat.logService.service.TokenService;

import java.util.HashMap;

@Service("commonLogService")
public class CommonLogService implements LogService {
    @Autowired
    LogMapper mapper;
    @Autowired
    TokenService service;
    @Override
    public String logByID(String id, String pwd) {
        User user=mapper.getUserByID(id);
        System.out.println("id:"+id);
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(mapper.getUserByID(id).isRightPWD(pwd)){
            return service.getToken(new HashMap<>(){
                {
                    put("id",id);
                    put("pwd",pwd);
                    put("isAccountNonExpired","false");
                }
            });
        }
        return "wrongPWD";
    }
//成功则返回token
    @Override
    public String logByEmail(String email, String pwd) {
        User user=mapper.getUserByEmail(email);
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(user.isRightPWD(pwd)){
            return service.getToken(new HashMap<>(){
                {
                    put("id",user.getId());
                    put("pwd",pwd);
                    put("isAccountNonExpired","false");
                }
            });
        }
        return "wrongPWD";
    }
}
