package wiki.common_cat.auditService.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.auditService.entities.User;
import wiki.common_cat.auditService.mapper.AuditMapper;
import wiki.common_cat.auditService.entities.Doc;
import wiki.common_cat.auditService.service.AuditService;
import wiki.common_cat.auditService.service.EmailService;

import javax.annotation.Resource;

@Service("commonAuditService")
public class CommonAuditService implements AuditService {
    @Resource(name = "commonEmailService")
    private EmailService emailService;
    @Autowired
    private AuditMapper mapper;
    private Jedis jedis=new Jedis("localhost");
    @Override
    public void commit(String sessionID) {
        Doc srcDoc= mapper.getDoc(Integer.valueOf(jedis.get(sessionID)));
        mapper.delAuditDoc(srcDoc.getId());
        mapper.auditDoc(srcDoc.getId());
    }

    @Override
    public void reject(int id,String comment) {
        emailService.sendMessage("你提交"+mapper.getDoc(id).getDate()+"的花名册被拒绝了。 建议："+comment,"tulpa花名册审核结果",new String[]{(mapper.getEMailByID(id))});
        mapper.rejectDoc(Integer.valueOf(id));
    }

    @Override
    public void accept(int id,String comment) {
        Doc doc= mapper.getAuditingDoc(Integer.valueOf(id));
        emailService.sendMessage("你提交"+doc.getDate()+"的花名册被通过了。建议：+comment","tulpa花名册审核结果。 ",new String[]{(mapper.getEMailByID(id))});
        mapper.delAuditDoc(id);
        mapper.acceptDoc(mapper.getDoc(id).getHTML(),Integer.valueOf(id));
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
