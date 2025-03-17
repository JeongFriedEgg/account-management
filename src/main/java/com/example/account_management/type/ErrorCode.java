package com.example.account_management.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTED(1000,"이미 존재하는 아이디입니다.")
    ;
    private final int code;
    private final String message;

}