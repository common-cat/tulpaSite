package wiki.common_cat.auditService.service;

public interface AuditService {
    void commit(String sessionID);
    void reject(int id);
    void accept(int id);
    boolean isAdmin(String sessionID);
    int[] getAuditList();
}
