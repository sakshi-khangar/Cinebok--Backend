package com.cinebokk.security;



import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private long expiration;

	private SecretKey getKey() {

		return Keys.hmacShaKeyFor(secret.getBytes());

	}

	public String generateToken(String email) {

		return Jwts.builder()

				.subject(email)

				.issuedAt(new Date())

				.expiration(new Date(System.currentTimeMillis() + expiration))

				.signWith(getKey())

				.compact();

	}

	public String extractEmail(String token) {

		return getClaims(token).getSubject();

	}

	public boolean validate(String token) {

		try {

			getClaims(token);

			return true;

		}

		catch (Exception e) {

			return false;

		}

	}

	private Claims getClaims(String token) {

		return Jwts.parser()

				.verifyWith(getKey())

				.build()

				.parseSignedClaims(token)

				.getPayload();

	}

}