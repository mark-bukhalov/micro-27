package org.example.gatewayservice.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private static final String SECRET = "c2VjcmV0a2V5Zm9yamF3dG9rZW5nZW5lcmF0aW9uMTIz";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

    public boolean validateToken(String token) {
        Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);

        return true;
    }
}