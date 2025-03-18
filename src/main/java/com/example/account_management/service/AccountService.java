package com.example.account_management.service;

import com.example.account_management.domain.Account;
import com.example.account_management.domain.User;
import com.example.account_management.dto.AccountDto;
import com.example.account_management.exception.AccountLimitExceededException;
import com.example.account_management.exception.UserNotFoundException;
import com.example.account_management.repository.AccountRepository;
import com.example.account_management.repository.UserRepository;
import com.example.account_management.type.AccountStatus;
import com.example.account_management.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    private static final int MAX_ACCOUNT_COUNT = 10;

    public AccountDto createAccount(AccountDto accountDto) {
        // 사용자 아이디 유무 체크
        User user = userRepository.findByUsername(accountDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));

        // 계좌 10개 이상인지 체크
        long accountCount = accountRepository.countByUserId(user.getId());
        if (accountCount >= MAX_ACCOUNT_COUNT) {
            throw new AccountLimitExceededException(ErrorCode.ACCOUNT_LIMIT_EXCEEDED);
        }

        // 계좌명 설정이 있는지 확인하고 없으면, 사용자의 이름값으로 설정
        String accountName = accountDto.getAccountName();
        if (accountName == null || accountName.trim().isEmpty()) {
            accountName = user.getName();
        }
        return AccountDto.fromEntity(
                user,
                accountRepository.save(Account.builder()
                                        .userId(user.getId())
                                        .accountNumber(generateAccountNumber())
                                        .accountPassword(accountDto.getAccountPassword())
                                        .balance(accountDto.getBalance())
                                        .accountName(accountName)
                                        .status(AccountStatus.ACTIVE)
                                        .build())
        );
    }

    // 10자리의 랜덤 계좌번호 생성
    private String generateAccountNumber() {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1_000_000_000));
    }
}
