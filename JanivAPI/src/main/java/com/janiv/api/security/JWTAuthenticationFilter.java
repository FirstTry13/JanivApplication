package com.janiv.api.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.janiv.api.model.MyUserDetails;
import com.janiv.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.janiv.api.Utilities.Constants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	@Autowired
	@Bean
	public JwtTokenUtil jwtTokenUtil() {
		return new JwtTokenUtil();
	}
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
			HttpServletResponse res) throws AuthenticationException {
		try {
			User creds = new ObjectMapper()
					.readValue(req.getInputStream(), User.class);

			Long mobilenumber = creds.getMobilenumber();
			String password = creds.getPassword();

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							mobilenumber,
							password,
							new ArrayList<>())
					);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		/*
    	//Creating JWT token as authentication is successfull 
        String token = JWT.create()
                .withSubject(((MyUserDetails) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
		 */
		
		MyUserDetails userDetails = ((MyUserDetails) auth.getPrincipal());    	
		String token = jwtTokenUtil().generateToken(userDetails);

		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

		//return ResponseEntity.ok(new JwtResponse(token));
	}
}