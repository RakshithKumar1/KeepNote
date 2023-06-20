package com.example.service;



import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.model.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTTokenGeneratorService implements TokenGeneratorService  {
	
	@Value("${jwt.secret.key}")
	private String testsecretKey;

	@Override
	public Map<String, String> generateToken(User user) {
		String token = Jwts.builder().setSubject(user.getUserName())
		.setIssuer("NoteIssuer")
		.setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256, testsecretKey)
		.compact();
		return Map.of("token",token);
	}

}

