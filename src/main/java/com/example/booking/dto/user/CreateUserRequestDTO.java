package com.example.booking.dto.user;

import lombok.Data;

//todo add field validation
@Data
public class CreateUserRequestDTO {

    private String fullName;
    private String email;
    private String phone;
    private String login;
    private String password;
    private Short roleId;
}
