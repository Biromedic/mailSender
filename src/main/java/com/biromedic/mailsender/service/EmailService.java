package com.biromedic.mailsender.service;


import com.biromedic.mailsender.DTO.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailDto emailDto) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailDto.getRecipient());
        mail.setSubject(emailDto.getSubject());

        String body = "FullName: " + emailDto.getFullname() + "\n";
        body += "Phone: " + emailDto.getPhone() + "\n";

        mail.setText(body);
        mailSender.send(mail);
    }


}
