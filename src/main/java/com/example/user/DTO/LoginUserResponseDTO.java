package com.example.user.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor  // 파람이터가 없는 생성자를 정의
public class LoginUserResponseDTO {
    private Long id;
    private String email;
    private String nick_name;
}
