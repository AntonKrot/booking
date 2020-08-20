package com.example.booking.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestDTO {

    @NotBlank
    private String fullName;
    @NotBlank
    @Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$", message = "Почта написана некорректно")
    private String email;
    @NotBlank
    @Pattern(regexp = "[0-9]{11,12}$", message = "Номер телефона написан некорректно")
    private String phone;
    @NotBlank
    @Size(min = 4, max = 16)
    private String login;
    //todo
    // Пароль должен приходить в захешированом виде (md5)
//    @Pattern(regexp = "^[a-f0-9]{32}$", message = "password is incorrect")
    private String password;
    @NotNull
    private Short roleId;
}
