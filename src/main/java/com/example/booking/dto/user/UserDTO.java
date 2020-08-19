package com.example.booking.dto.user;

import com.example.booking.dto.dictionary.DictionaryDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String login;
    private DictionaryDTO role;
}
