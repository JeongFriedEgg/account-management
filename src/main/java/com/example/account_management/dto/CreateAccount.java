package com.example.account_management.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateAccount {
    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Request {
        @NotBlank(message = "사용자 아이디를 입력해 주세요.")
        private String username;
        @Pattern(regexp = "^[0-9]{4}$", message = "계좌 비밀번호는 4자리 숫자여야 합니다.")
        private String accountPassword;
        private BigDecimal initBalance;
        private String accountName;

        public static AccountDto toDto(Request request) {
            return AccountDto.builder()
                    .username(request.getUsername())
                    .accountPassword(request.getAccountPassword())
                    .balance(request.getInitBalance())
                    .accountName(request.getAccountName())
                    .build();
        }
    }

    @Builder
    @Getter
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Response {
        private String username;
        private String accountNumber;
        private BigDecimal balance;
        private String accountName;
        private LocalDateTime createdAt;

        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .username(accountDto.getUsername())
                    .accountNumber(accountDto.getAccountNumber())
                    .balance(accountDto.getBalance())
                    .accountName(accountDto.getAccountName())
                    .createdAt(accountDto.getCreatedAt())
                    .build();
        }
    }
}
