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
    public void commit(String id) {
        Doc srcDoc= mapper.getDoc(id);
        mapper.auditDoc(srcDoc.HTML,srcDoc.authorID,srcDoc.status);
    }

    @Override
    public void reject(String id) {
        mapper.rejectDoc(id);
    }

    @Override
    public void accept(String id) {
        Doc doc= mapper.getAuditingDoc(id);
        mapper.acceptDoc(doc.HTML,id, doc.status);
        mapper.delAuditDoc(id);
    }

    @Override
    public boolean isAdmin(String sessionID) {
        String realID=jedis.get(sessionID);
        return mapper.isAdmin(realID)!=null;
    }

    @Override
    public String[] getAuditList() {
        return mapper.auditList();
    }
}
