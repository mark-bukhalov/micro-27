package org.example.identityservice.usecases.service_impl;

import lombok.RequiredArgsConstructor;
import org.example.identityservice.data.entity.User;
import org.example.identityservice.repository.UserRepository;
import org.example.identityservice.usecases.dto.TokenResponseDto;
import org.example.identityservice.usecases.dto.UserDto;
import org.example.identityservice.usecases.service.AuthService;
import org.example.identityservice.usecases.service.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void registerNewUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        userRepository.save(user);
    }

    @Override
    public TokenResponseDto authenticate(UserDto userDto) {
        User user = userRepository
                .findByUsername(userDto.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(userDto.password(), user.getPassword())) {
            return new TokenResponseDto(jwtService.generateToken(user));
        } else {
            throw new BadCredentialsException("Bad Credentials");
        }
    }
}