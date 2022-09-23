package com.ctc.birthday.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {
    // 邮箱
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String email_from;

    /**
     * 发送邮件
     */
    public void send(String subject,String email,String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setFrom(email_from);
        message.setBcc(email);
        message.setSentDate(new Date());
        message.setText(text);
        javaMailSender.send(message);
    }
}
