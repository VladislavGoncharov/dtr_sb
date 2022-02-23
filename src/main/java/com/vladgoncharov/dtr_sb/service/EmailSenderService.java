package com.vladgoncharov.dtr_sb.service;

import com.vladgoncharov.dtr_sb.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEMail, String currentUsername) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("datetimeresult@gmail.com");
        mailMessage.setTo(toEMail);
        mailMessage.setSubject("Подтвердить email на сайте DateTimeResult.ru");
        mailMessage.setText("Здравствуйте " + currentUsername + ". \nЧтобы подтвердить свою почту " +
                "нужно перейти по этой ссылке->" +
                "https://datetimeresult.ru/confirmYourEmailAddress_"
                + currentUsername);

        mailSender.send(mailMessage);

        System.out.println("Email Sent Successfully!! " + toEMail);
    }

    public void confirmYourEmailAddress(String currentUsername) {
        AppUser user = (AppUser) userServiceInterface.findUserByAccount(currentUsername);

        user.getAppUserInfo().setCheckingEmail(true);

        userServiceInterface.updateInfo(user.getAppUserInfo());
    }
}




