package com.example.booking.dto.user;

import lombok.Data;

//todo add field validation
@Data
public class UpdateUserRequestDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String login;
    private Short roleId;
}
