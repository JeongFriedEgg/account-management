package com.example.account_management.exceptionhandler;

import com.example.account_management.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int code;
    private final String message;

    public ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}