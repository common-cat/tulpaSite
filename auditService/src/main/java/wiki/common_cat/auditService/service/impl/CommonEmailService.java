package wiki.common_cat.auditService.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wiki.common_cat.auditService.service.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.Properties;


@Service("commonEmailService")
public class CommonEmailService implements EmailService {
    @Value("${mail.port}")
    String port;
    @Value("${mail.host}")
    String HOST;
    @Value("${mail.user}")
    String FROM;
    @Value("${mail.user}")
    String USER;
    @Value("${mail.pwd}")
    String PWD;
    @Override
    public void sendMessage(String content, String subject, String[] TOS) {
        Properties props = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", "true");
        //System.out.println("mailPort:"+port);
        props.put("mail.smtp.port", port);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(FROM));
            InternetAddress[] sendTo = new InternetAddress[TOS.length];
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));
            message.setSubject(subject);
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(content);
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PWD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
