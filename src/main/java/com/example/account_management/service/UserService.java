package com.example.account_management.service;

import com.example.account_management.domain.User;
import com.example.account_management.dto.UserDto;
import com.example.account_management.exception.UserAlreadyExistException;
import com.example.account_management.repository.UserRepository;
import com.example.account_management.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(String username, String password, String name) {
        userRepository.findByUserId(username)
                .ifPresent(user -> {
                    throw new UserAlreadyExistException(ErrorCode.USER_ALREADY_EXISTED);
                });

        return UserDto.fromEntity(
                userRepository.save(
                        User.builder()
                                .username(username)
                                .password(password)
                                .name(name)
                                .build()
                )
        );
    }
}