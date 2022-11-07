package wiki.common_cat.auditService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.auditService.entities.User;
import wiki.common_cat.auditService.entities.Doc;

@Mapper
public interface AuditMapper {
    User getUserInfo(int id);
    Doc getAuditedDoc(int id);
    Doc getAuditingDoc(int id);
    Doc getDoc(int id);
    void acceptDoc(String HTML,int id);
    void rejectDoc(int id);
    void delAuditDoc(int id);
    String getEMailByID(int id);
    void auditDoc(int id);
    Integer isAdmin(int id);
    void delAudited(int id);
    int[] auditList();
    Integer existAuditDoc();
}
