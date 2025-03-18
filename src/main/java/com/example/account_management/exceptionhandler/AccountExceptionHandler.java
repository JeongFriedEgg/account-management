package com.example.account_management.exceptionhandler;

import com.example.account_management.exception.AccountLimitExceededException;
import com.example.account_management.type.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountExceptionHandler {
    @ExceptionHandler(AccountLimitExceededException.class)
    public ResponseEntity<ErrorResponse> handleAccountLimitExceededException(AccountLimitExceededException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.ACCOUNT_LIMIT_EXCEEDED);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
