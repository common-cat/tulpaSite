package wiki.common_cat.signinService.service;

public interface EmailService {
    void sendMessage(String content,String subject,String[] TOS);
}
