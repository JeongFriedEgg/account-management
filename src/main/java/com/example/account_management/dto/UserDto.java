package com.example.account_management.dto;

import com.example.account_management.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UserDto {
    private String username;
    private String password;
    private String name;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}