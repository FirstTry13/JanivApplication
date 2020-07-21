package com.janiv.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.janiv.api.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static com.janiv.api.Utilities.Constants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authManager) {
		super(authManager);
	}

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	@Bean
	public JwtTokenUtil jwtTokenUtil() {
		return new JwtTokenUtil();
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		//Reading token using header name
		String requestTokenHeader = req.getHeader(HEADER_STRING);

		// If header available and starts with define set token prefix 
		// then only process else return back control
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null && requestTokenHeader.startsWith(TOKEN_PREFIX)) {

			//Getting token by ignore token prefix
			jwtToken = requestTokenHeader.substring(TOKEN_PREFIX.length());

			try {
				//Getting user name from JWT Token
				username = jwtTokenUtil().getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String (Token Prefix)");
		}
		
		
		// Once we get the token validate it.
		if (username != null && 
				SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil().validateToken(jwtToken, userDetails)) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
				.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
				
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		chain.doFilter(req, res);
	}


}