package com.example.account_management.exceptionhandler;

import com.example.account_management.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ErrorResponse {
    private final int code;
    private final List<String> messages;

    public ErrorResponse(ErrorCode errorCode, List<String> messages) {
        this.code = errorCode.getCode();
        this.messages = messages;
    }

    public ErrorResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.messages = Collections.singletonList(errorCode.getMessage());
    }
}