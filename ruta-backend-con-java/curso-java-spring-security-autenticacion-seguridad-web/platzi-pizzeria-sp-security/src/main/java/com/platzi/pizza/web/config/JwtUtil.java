package com.platzi.pizza.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private static String SECRET_KEY = "d4n1el_pl4tz1";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
    public String create(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("daniel-pizza-platzi")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5)))
                .sign(ALGORITHM);
    }
}
