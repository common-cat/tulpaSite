package wiki.common_cat.auditService.mapper;

import org.apache.ibatis.annotations.Mapper;
import wiki.common_cat.auditService.entities.Doc;
@Mapper
public interface AuditMapper {
    Doc getAuditedDoc(String authorID);
    Doc getAuditingDoc(String authorID);
    Doc getDoc(String authorID);
    void acceptDoc(String HTML,String authorID,int status);
    void rejectDoc(String authorID);
    void delAuditDoc(String authorID);
    void auditDoc(String HTML,String authorID,int status);
    String isAdmin(String id);
    String[] auditList();
}
