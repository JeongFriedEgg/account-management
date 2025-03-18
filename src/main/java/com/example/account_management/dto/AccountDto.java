package com.example.account_management.dto;

import com.example.account_management.domain.Account;
import com.example.account_management.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class AccountDto {
    private String username;
    private String accountNumber;
    private String accountPassword;
    private BigDecimal balance;
    private String accountName;
    private LocalDateTime createdAt;

    public static AccountDto fromEntity(User user, Account account) {
        return AccountDto.builder()
                .username(user.getUsername())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .accountName(account.getAccountName())
                .createdAt(account.getCreatedAt())
                .build();
    }
}
