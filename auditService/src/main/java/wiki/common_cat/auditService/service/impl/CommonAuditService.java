package wiki.common_cat.auditService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import wiki.common_cat.auditService.entities.Doc;
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
        mapper.auditDoc(srcDoc.HTML,srcDoc.authorID);
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
        return mapper.isAdmin(Integer.valueOf(realID))!=null;
    }

    @Override
    public int[] getAuditList() {
        return mapper.auditList();
    }
}
