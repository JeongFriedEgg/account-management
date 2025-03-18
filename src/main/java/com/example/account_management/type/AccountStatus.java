package com.example.account_management.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountStatus {
    ACTIVE("정상"),
    SUSPENDED("정지");

    private final String description;
}
