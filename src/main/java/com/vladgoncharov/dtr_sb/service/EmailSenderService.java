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

    public void sendEmail(String fromEmail, String toEMail, String subject, String body) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromEmail);
        mailMessage.setTo(toEMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        mailSender.send(mailMessage);

        System.out.println("Email Sent Successfully!!");

    }

    public void confirmYourEmailAddress(String currentUsername) {
        AppUser user = (AppUser) userServiceInterface.findUserAccount(currentUsername);

        user.getAppUserInfo().setCheckingEmail(true);

        userServiceInterface.updateInfo(user.getAppUserInfo());
    }
}




