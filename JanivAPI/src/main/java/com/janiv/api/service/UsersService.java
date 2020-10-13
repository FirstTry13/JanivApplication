package com.janiv.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.janiv.api.model.JwtResponse;
import com.janiv.api.model.User;
import com.janiv.api.repository.UsersRepository;
import com.janiv.api.security.JwtTokenUtil;

@Service
public class UsersService {

	@Autowired  
	UsersRepository usersRepository;  

	@Autowired	
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired	
	private UserDetailsServiceImpl userDetailsService()
	{
		return new UserDetailsServiceImpl(usersRepository);
	}

	//encode password for encrypting password
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UsersService(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;	
		
	}

	public List<User> getAllUsers() {		
		List<User> users = new ArrayList<User>();  
		//usersRepository.findAll().forEach(user1 -> users.add(user1));  
		return users;  
	}

	public User getUserByMobileNo(Long mobilenumber) {
		User user=usersRepository.getUserByUsername(mobilenumber);
		return user;
	}

	public void saveOrUpdate(User user) {

		//Getting password send by user (plain text password)
		String password = user.getPassword();

		//If password is provided then encrypting it
		if ( (password == null)  || (password.length() != 0 ) )
		{
			//Encrypt password
			user.setPassword(this.passwordEncoder.encode(password));
		}

		//usersRepository.save(user); 

	}

	public void delete(Long mobilenumber) {
		//usersRepository.deleteById(mobilenumber);

	}

	public String authenticate(String mobilenumber, String password) throws Exception {

		try
		{
			System.out.print(this.passwordEncoder.encode(password));
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobilenumber, password));

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	
		
		final UserDetails userDetails = userDetailsService().loadUserByUsername(mobilenumber);

		final String token = jwtTokenUtil.generateToken(userDetails);


		return token;
	}






}
