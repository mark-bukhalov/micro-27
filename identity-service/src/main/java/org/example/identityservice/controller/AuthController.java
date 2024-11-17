package org.example.identityservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.identityservice.usecases.dto.TokenResponseDto;
import org.example.identityservice.usecases.dto.UserDto;
import org.example.identityservice.usecases.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody UserDto userDto) {
        log.info("Register: {}", userDto.username());
        authService.registerNewUser(userDto);
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponseDto> generateToken(@RequestBody UserDto userDto) {
        log.info("Generate token for {}", userDto.username());
        TokenResponseDto tokenResponse = authService.authenticate(userDto);
        return ResponseEntity.ok(tokenResponse);
    }
}