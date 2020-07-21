package com.janiv.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.janiv.api.model.MyUserDetails;
import com.janiv.api.model.User;
import com.janiv.api.repository.UsersRepository;

//@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(Long.parseLong(username));
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user" + username);
		}
		
		return new MyUserDetails(user);
	}

}