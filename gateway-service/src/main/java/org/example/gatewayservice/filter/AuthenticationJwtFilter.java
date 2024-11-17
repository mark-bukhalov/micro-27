package org.example.gatewayservice.filter;

import org.example.gatewayservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationJwtFilter extends AbstractGatewayFilterFactory<AuthenticationJwtFilter.Config> {

    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationJwtFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new SecurityException("Mising authorization header");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
                jwtUtil.validateToken(authHeader);
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
    }
}