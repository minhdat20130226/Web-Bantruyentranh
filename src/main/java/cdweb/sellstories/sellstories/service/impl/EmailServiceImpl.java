package cdweb.sellstories.sellstories.service.impl;

import cdweb.sellstories.sellstories.service.EmailService;
import cdweb.sellstories.sellstories.util.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.verify.host}")
    private String host;
    @Value("${spring.datasource.username}")
    private String fromEmail;
    private JavaMailSender javaMailSender;


    @Override
    public void sendSimpleMailMessage(String name, String to, String token) {
        try{
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Kích hoạt tài khoản Stories");
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setText(EmailUtils.getEmailMessage(name,host,token));
        javaMailSender.send(message);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }
        }
}
