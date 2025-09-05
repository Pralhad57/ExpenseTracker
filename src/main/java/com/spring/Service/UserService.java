package com.spring.Service;

import com.spring.Entity.Users;

public interface UserService {

	boolean save(Users user);

	boolean login(String un, String pwd);

	Users findByuserName(String userName);

}
