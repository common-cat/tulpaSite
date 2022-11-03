package wiki.common_cat.signinService.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wiki.common_cat.signinService.service.EmailService;

import java.util.Properties;

import javax.mail.BodyPart;

import javax.mail.Message;

import javax.mail.Multipart;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeBodyPart;

import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMultipart;


@Service("commonEmailService")
public class CommonEmailService implements EmailService {
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
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", "true");
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
