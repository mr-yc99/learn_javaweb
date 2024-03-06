package com.learnjava.demotlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class DemoTliasApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "learnjava").
                setClaims(claims).
                setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)).compact();

        System.out.println(jwt);

    }

    @Test
    public void testParseJWT() {
        Claims body = Jwts.parser().setSigningKey("learnjava").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcwOTM4NjQ3MH0.35YTVlq3SPYbF3KrHW1BP09VJZdwDKQgj75V21NV5Cs")
                .getBody();
        System.out.println(body);


    }

}
