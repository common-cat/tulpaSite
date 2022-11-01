package wiki.common_cat.auditService.service;

public interface AuditService {
    void commit(String id);
    void reject(String id);
    void accept(String id);
    boolean isAdmin(String sessionID);
    String[] getAuditList();
}
