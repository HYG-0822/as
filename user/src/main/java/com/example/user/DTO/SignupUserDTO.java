package com.example.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupUserDTO {
    private String email;
    private String password;
    private String nick_name;
}
