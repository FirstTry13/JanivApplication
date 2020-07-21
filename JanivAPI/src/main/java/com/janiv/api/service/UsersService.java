package com.janiv.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.janiv.api.model.User;
import com.janiv.api.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired  
	UsersRepository usersRepository;  

	//encode password for encrypting password
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public List<User> getAllUsers() {		
		List<User> users = new ArrayList<User>();  
		usersRepository.findAll().forEach(user1 -> users.add(user1));  
		return users;  
	}

	public Optional<User> getUserByMobileNo(Long mobilenumber) {
		return usersRepository.findById(mobilenumber);
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

		usersRepository.save(user); 

	}

	public void delete(Long mobilenumber) {
		usersRepository.deleteById(mobilenumber);

	}

	public User authenticate(Long mobilenumber, String password) {

		//TODO: Actual authentication implementation required
		User user = new User();
		user.setMobilenumber(mobilenumber);
		user.setFirstname("Sandeep");
		user.setLastname("l");

		return user;
	}



}
