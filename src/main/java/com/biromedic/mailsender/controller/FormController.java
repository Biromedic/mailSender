package com.biromedic.mailsender.controller;

import com.biromedic.mailsender.DTO.EmailDto;
import org.springframework.web.bind.annotation.*;
import com.biromedic.mailsender.service.EmailService;

@RestController
@RequestMapping("/")
public class FormController {
    private final EmailService emailService;


    public FormController(EmailService emailService){
        this.emailService = emailService;
    }

    @GetMapping("/show")
    public String showForm(){
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestBody EmailDto emailDto)
    {
        try {
            emailService.sendEmail(emailDto);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}

