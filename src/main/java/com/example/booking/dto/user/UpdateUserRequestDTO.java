package com.example.booking.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequestDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String fullName;
    @NotBlank
    @Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$", message = "email is incorrect")
    private String email;
    @Pattern(regexp = "[0-9]{11,12}$", message = "phone number is incorrect")
    private String phone;
    @NotBlank
    @Size(min = 4, max = 16)
    private String login;
    @NotNull
    private Short roleId;
}
