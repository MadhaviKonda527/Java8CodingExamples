package com.interviewtrackingsystem.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtTokenProvider {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.expiration}")
	private int jwtExpirationInMs;
	
	public String generateToken(Authentication authentication) {
		UserPrincipal userPrincipal = (UserPrincipal)authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		return Jwts.builder()
				.setSubject(userPrincipal.getId().toString())
				.setIssuesAt(new Date()).
				.setExpiration(expiryDate)
				.signWith(getSigningKey(), SignatureAlogorithm.HS512)
				.compact();
	}
	
	public Claims getClaimsFromJWT(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean validateToken(String authToken) {
		try {
			Jwts.parserBuilder()
			.setSigningKey(getSigningKey())
			.parseClaimsJws(authToken);
			
		return true;
		}catch(MalformedJwtException ex) {
			//Invalid JWT Token
		}catch(ExpiredJwtException ex) {
			//Invalid JWT Token
		}catch(UnsupportedJwtException ex) {
			//Invalid JWT Token
		}catch(IllegalArgumentException ex) {
			//Invalid JWT Token
		}
		return false;
	}
	
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	

}
