package wiki.common_cat.auditService.service;

public interface AuditService {
    void commit(String sessionID);
    void reject(int id,String comment);
    void accept(int id,String comment);
    boolean isAdmin(String sessionID);
    String getAuditList();
}
