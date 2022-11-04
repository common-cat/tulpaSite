package wiki.common_cat.auditService.service;

public interface EmailService {
    void sendMessage(String content,String subject,String[] TOS);
}
