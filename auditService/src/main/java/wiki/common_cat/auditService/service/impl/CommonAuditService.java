package wiki.common_cat.auditService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.auditService.entities.Doc;
import wiki.common_cat.auditService.entities.User;
import wiki.common_cat.auditService.mapper.AuditMapper;
import wiki.common_cat.auditService.service.AuditService;
@Service("commonAuditService")
public class CommonAuditService implements AuditService {
    @Autowired
    private AuditMapper mapper;
    private Jedis jedis=new Jedis("localhost");
    @Override
    public void commit(String sessionID) {
        Doc srcDoc= mapper.getDoc(Integer.valueOf(jedis.get(sessionID)));
        mapper.delAuditDoc(srcDoc.getId());
        mapper.auditDoc(srcDoc.HTML,srcDoc.getId());
    }

    @Override
    public void reject(int id) {
        mapper.rejectDoc(Integer.valueOf(id));
    }

    @Override
    public void accept(int id) {
        Doc doc= mapper.getAuditingDoc(Integer.valueOf(id));
        mapper.acceptDoc(doc.HTML,Integer.valueOf(id));
        mapper.delAuditDoc(Integer.valueOf(id));
    }

    @Override
    public boolean isAdmin(String sessionID) {
        String realID=jedis.get(sessionID);
        int id=Integer.valueOf(realID);
        return mapper.isAdmin(id)!=null;
    }

    @Override
    public String getAuditList() {
        int[] ids=mapper.auditList();
        User[] users=new User[ids.length];
        for(int i=0;i< ids.length;i++){
            System.out.println("id:"+ids[i]);
            users[i]=mapper.getUserInfo(ids[i]);
        }
        for(User user:users){
            System.out.println(user);
        }
        return (new Gson()).toJson(users);
    }
}
