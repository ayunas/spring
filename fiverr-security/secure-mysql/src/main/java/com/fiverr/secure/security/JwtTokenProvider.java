package com.fiverr.secure.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	//need secret and expiration time
	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration}")
	private int jwtExpiration;

	//accept token from user to generate a claim, generate token, validate token
	public String genToken(Authentication auth) {
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpiration);

		return Jwts.builder()
					.setSubject(Long.toString(userPrincipal.getId()))
					.setIssuedAt(new Date()).setExpiration(expiry)
					.signWith(SignatureAlgorithm.HS512,jwtSecret)
					.compact();
	}

	public Long getUserIdFromJwt(String token) {  //claim : the subject inserted into a JWT token
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch(SignatureException se) {
			logger.error("Invalid JWT signature");
		} catch(MalformedJwtException mje) {
			logger.error("Invalid JWT token");
		} catch(ExpiredJwtException eje) {
			logger.error("Expired JWT token");
		} catch (UnsupportedJwtException uje) {
			logger.error("Unsupported JWT token");
		} catch(IllegalArgumentException iae) {
			logger.error("JWT claims string is empty");
		}
		return false;
	}





}
