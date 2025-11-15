package com.example.user.Entity;

import com.example.user.DTO.LoginUserResponseDTO;
import com.example.user.DTO.SignupUserDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(name = "nick_name", nullable = false, length = 100)
    private String nickName;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role = Role.ROLE_USER;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    public static User fromDTO(SignupUserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setNickName(dto.getNick_name());

        return user;
    }

    public static LoginUserResponseDTO toLoginUserResponse(User user) {
        LoginUserResponseDTO dto = new LoginUserResponseDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setNick_name(user.getNickName());
        return dto;
    }

    public enum Role {
        ROLE_ADMIN,
        ROLE_USER
    }
}
