package com.example.account_management.service;

import com.example.account_management.domain.User;
import com.example.account_management.dto.UserDto;
import com.example.account_management.exception.UserAlreadyExistException;
import com.example.account_management.repository.UserRepository;
import com.example.account_management.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        userRepository.findByUsername(userDto.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException(ErrorCode.USER_ALREADY_EXISTED);
                });

        return UserDto.fromEntity(
                userRepository.save(
                        User.toEntity(userDto)
                )
        );
    }
}