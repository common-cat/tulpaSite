package wiki.common_cat.logService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.logService.entities.User;
import wiki.common_cat.logService.mapper.LogMapper;
import wiki.common_cat.logService.service.LogService;
import wiki.common_cat.logService.service.Res;

import java.util.HashMap;

@Service("commonLogService")
public class CommonLogService implements LogService {
    @Autowired
    LogMapper mapper;
    Jedis jedis=new Jedis("localhost");
    @Override
    public String logByID(String sessionID,String id, String pwd) {
        User user=mapper.getUserByID(id);
        System.out.println("id:"+id);
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(mapper.getUserByID(id).isRightPWD(pwd)){
            System.out.println("sessionID:"+sessionID);
            System.out.println("id:"+id);
            jedis.set(sessionID,id);
            return (new Gson()).toJson(new Res(sessionID,id));
        }
        return "wrongPWD";
    }
//成功则返回token
    @Override
    public String logByEmail(String sessionID,String email, String pwd) {
        User user=mapper.getUserByEmail(email);
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(user.isRightPWD(pwd)){
            jedis.set(sessionID,user.getId());
            return (new Gson()).toJson(new Res(sessionID,user.getId()));
        }
        return "wrongPWD";
    }
}
