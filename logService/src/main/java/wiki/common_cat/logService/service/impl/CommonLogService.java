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
        try{
        User user=mapper.getUserByID(Integer.valueOf(id));
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),Integer.valueOf(user.getId()));
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(mapper.getUserByID(Integer.valueOf(id)).isRightPWD(pwd)){
            System.out.println("login-id:"+id);
            jedis.set(sessionID,id);
            return (new Gson()).toJson(new Res(sessionID,Integer.valueOf(id)));
        }}catch (Exception e){

        }
        return "wrongPWD";
    }
//成功则返回token
    @Override
    public String logByEmail(String sessionID,String email, String pwd) {
        try{
        User user=mapper.getUserByEmail(email);
        if(!user.tryRightTimes()){
            mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
            return "wrongTimes";
        }
        mapper.setUser(user.getLastLoginDate(), user.getStatus(),user.getLoginTimes(),user.getId());
        if(user.isRightPWD(pwd)){
            jedis.set(sessionID,String.valueOf(user.getId()));
            System.out.println("login-id:"+user.getId());
            return (new Gson()).toJson(new Res(sessionID,user.getId()));
        }}catch (Exception e){

        }
        return "wrongPWD";
    }

    @Override
    public String sessionID(String sessionID) {
        String id= jedis.get(sessionID);
        if(id==null){
            return "401";
        }else {
            return id;
        }
    }
}
