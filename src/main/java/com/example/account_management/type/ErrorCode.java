package com.example.account_management.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_INPUT(1000,"부적절한 입력입니다."),

    USER_ALREADY_EXISTED(1100,"이미 존재하는 아이디입니다."),
    USER_NOT_FOUND(1101,"아이디가 존재하지 않습니다."),

    ACCOUNT_LIMIT_EXCEEDED(1200,"더 이상 계좌를 생성할 수 없습니다.(계정 당 최대 10개)"),
    ;
    private final int code;
    private final String message;

}