package org.example.identityservice.usecases.service_impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.identityservice.data.entity.User;
import org.example.identityservice.usecases.service.JwtService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private static final String SECRET = "c2VjcmV0a2V5Zm9yamF3dG9rZW5nZW5lcmF0aW9uMTIz";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

    @Override
    public String generateToken(User user) {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + 1000 * 60 * 30);

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("username", user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public void validateToken(String token) {
        Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }
}