package io.javabrains.secure.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class JwtUtil {
	private static final String SECRET_KEY = "secret";

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public String extractUsername(String token) {
		return extractClaim(token, claims -> claims.getSubject());
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, claims -> claims.getExpiration());
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Date getDate(long addedTime) {
		return new Date(System.currentTimeMillis() + addedTime);
	}

	public long hrsToMillis(int hrs) {
		return hrs * 60 * 60 * 1000;
	}

	private String createToken(Map<String,Object> claims, String subject) {

		Date current = getDate(0);
//		Date exp = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
		Date exp = getDate(hrsToMillis(10));

		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(current)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims,userDetails.getUsername());
	}


}
