package org.example.identityservice.usecases.service;

import org.example.identityservice.usecases.dto.TokenResponseDto;
import org.example.identityservice.usecases.dto.UserDto;

public interface AuthService {
    public void registerNewUser(UserDto userDto);

    public TokenResponseDto authenticate(UserDto userDto);
}