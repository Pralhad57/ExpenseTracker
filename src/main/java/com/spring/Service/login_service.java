package com.spring.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.Entity.Users;
import com.spring.Repository.UserRepository;

@Service
public class login_service implements UserDetailsService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = UserRepository.findByuserName(username)
				.orElseThrow(() -> new RuntimeException("User Not Registered"));

		return User.withUsername(user.getUserName()).password(user.getPassword()).build();
	}

}
