package com.biromedic.mailsender.DTO;

import lombok.Data;

@Data
public class EmailDto {

    private String recipient;
    private String subject;
    private String fullname;
    private String phone;


}
