package wiki.commoncat.auditService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.commoncat.auditService.entities.Doc;
import wiki.commoncat.auditService.entities.User;

@Mapper
public interface AuditMapper {
    User getUserInfo(int id);
    Doc getAuditedDoc(int id);
    Doc getAuditingDoc(int id);
    Doc getDoc(int id);
    void acceptDoc(String HTML,int id);
    void rejectDoc(int id);
    void delAuditDoc(int id);
    void auditDoc(String HTML,int id);
    Integer isAdmin(int id);
    int[] auditList();
    Integer existAuditDoc();
}
