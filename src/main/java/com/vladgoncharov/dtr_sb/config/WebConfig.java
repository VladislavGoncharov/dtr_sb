package com.vladgoncharov.dtr_sb.config;

import com.vladgoncharov.dtr_sb.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    EmailSenderService emailSenderService;

    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:validation");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    public void CheckEmail(){
        System.out.println("1");
        emailSenderService.sendEmail("datetimeresult@gmail.com",
                "veyvik87@gmail.com",
                "Sending email using Spring Booot",
                "Hey, How are you!! Sending an email for testing purpose!!");
        System.out.println("2");

    }

//
//
//    public void send(String subject, String from, String to, File file) throws MessagingException {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setSubject(subject);
//        helper.setFrom(from);
//        helper.setTo(to);
//        helper.setReplyTo(from);
//        helper.setText("stub", false);
//        helper.addAttachment("document.txt", file);
//        javaMailSender.send(message);
//    }
//    mail.transport.protocol = smtps
//    mail.smtp.host = smtp.yandex.ru
//    mail.smtp.port = 465
//    mail.smtp.user = artem.boiar
//    mail.smtp.ssl.enable = true
//    mail.smtp.auth = true
//    mail.debug = true
}
