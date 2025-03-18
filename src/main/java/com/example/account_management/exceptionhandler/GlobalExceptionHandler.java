package com.example.account_management.exceptionhandler;

import com.example.account_management.type.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();

        List<String> errorMessages = bindingResult.getAllErrors().stream()
                .map(error -> {
                    FieldError fieldError = (FieldError) error;
                    return fieldError.getDefaultMessage();
                })
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_INPUT, errorMessages);

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
