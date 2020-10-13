package com.janiv.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.janiv.api.model.JwtRequest;
import com.janiv.api.model.JwtResponse;
import com.janiv.api.model.User;
import com.janiv.api.security.JwtTokenUtil;
import com.janiv.api.service.UserDetailsServiceImpl;
import com.janiv.api.service.UsersService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserServiceController {
	
	//autowire the UsersService class  
	@Autowired  
	UsersService usersService;
	


	public UserServiceController(AuthenticationManager authenticationManager) {
		
	}
	 
	
	/* Returns all users list. Further can be enhanced to get users in batches*/
	@RequestMapping(value = "/users")
	public List<User> getUsers() 
	{ 
		return usersService.getAllUsers(); 
	}

	/* Returns particular user information */
	@RequestMapping(value = "/users/{mobilenumber}")
	public Optional<User> getUser(@PathVariable("mobilenumber") Long mobilenumber) 
	{
		//return usersService.getUserByMobileNo(mobilenumber);
		return null;

	}

	/* Creates (or Registers) user  */
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user) 
	{
		usersService.saveOrUpdate(user);  

		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}

	/* Updates user*/	
	@RequestMapping(value = "/users/update/{mobilenumber}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@PathVariable("mobilenumber") Long mobilenumber , @RequestBody User user) 
	{		
		usersService.saveOrUpdate(user);
		return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}

	/* Deletes user */
	@RequestMapping(value = "/users/{mobilenumber}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("mobilenumber") Long mobilenumber) { 

		usersService.delete(mobilenumber); 
		return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		String token = usersService.authenticate(authenticationRequest.getMobilenumber(), authenticationRequest.getPassword());
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
}
