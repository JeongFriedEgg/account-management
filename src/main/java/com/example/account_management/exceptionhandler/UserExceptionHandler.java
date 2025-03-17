package com.example.account_management.exceptionhandler;

import com.example.account_management.exception.UserAlreadyExistException;
import com.example.account_management.type.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handlerUserException(UserAlreadyExistException e) {
        ErrorResponse er = new ErrorResponse(ErrorCode.USER_ALREADY_EXISTED);
        return new ResponseEntity<>(er, HttpStatus.CONFLICT);
    }
}