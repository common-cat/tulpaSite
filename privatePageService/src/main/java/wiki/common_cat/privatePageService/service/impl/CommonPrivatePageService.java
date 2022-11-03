package wiki.common_cat.privatePageService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.privatePageService.mapper.PrivatePageMapper;
import wiki.common_cat.privatePageService.service.PrivatePageService;
@Service("commonPrivatePageService")
public class CommonPrivatePageService implements PrivatePageService {
    @Autowired
    private PrivatePageMapper mapper;
    private Jedis jedis=new Jedis("localhost");
    @Override
    public String getUserInfo(int id) {
        return (new Gson()).toJson(mapper.getUserInfo(id));
    }

    @Override
    public void setUserInfo(String sessionID, String tulpas, String hosts, String introduction) {
        String id=jedis.get(sessionID);
        System.out.println("set:"+id);
        if(id==null){
            return;
        }
        mapper.setUserInfo(Integer.valueOf(id),tulpas,hosts,introduction);
    }
}
