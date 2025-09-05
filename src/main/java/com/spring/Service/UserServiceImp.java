package com.spring.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Entity.Users;
import com.spring.Repository.UserRepository;
import com.spring.error.exception;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public boolean save(Users user) {
		Optional<Users> opt = UserRepository.findByuserName(user.getUserName());
		if (opt.isPresent()) {
			return false;
		}

		UserRepository.save(user);
		return true;

	}

	@Override
	public boolean login(String un, String pwd) {

		return UserRepository.findByuserNameAndPassword(un, pwd).isPresent();

	}

	@Override
	public Users findByuserName(String userName) {

		return UserRepository.findByuserName(userName).orElseThrow(() -> new exception("User Not Registered"));

	}

}
