package org.example.identityservice.usecases.service;

import org.example.identityservice.data.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    public String generateToken(User user);

    public void validateToken(String token);
}