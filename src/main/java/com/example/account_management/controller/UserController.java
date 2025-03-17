package com.example.account_management.controller;

import com.example.account_management.dto.CreateUser;
import com.example.account_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public CreateUser.Response createUser(
            @RequestBody CreateUser.Request createUser
    ) {
        return CreateUser.Response.from(
                userService.createUser(createUser.getUsername(),
                        createUser.getPassword(),
                        createUser.getName())
        );
    }
}