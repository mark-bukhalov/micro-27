package org.example.identityservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.identityservice.usecases.dto.TokenResponseDto;
import org.example.identityservice.usecases.dto.UserDto;
import org.example.identityservice.usecases.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public void registerUser(@RequestBody UserDto userDto) {
        authService.registerNewUser(userDto);
    }

    @PostMapping("/token")
    public TokenResponseDto generateToke(@RequestBody UserDto userDto) {
        return authService.authenticate(userDto);
    }
}