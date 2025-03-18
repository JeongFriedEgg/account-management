package com.example.account_management.exception;

import com.example.account_management.type.ErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotFoundException extends RuntimeException {
  private ErrorCode errorCode;
}
