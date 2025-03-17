package com.example.account_management.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


public class CreateUser {
    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Request {
        private String username;
        private String password;
        private String name;
    }

    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Response {
        private String username;
        private String name;
        private LocalDate createdAt;

        public static Response from(UserDto userDto){
            return Response.builder()
                    .username(userDto.getUsername())
                    .name(userDto.getName())
                    .createdAt(userDto.getCreatedAt())
                    .build();
        }
    }
}