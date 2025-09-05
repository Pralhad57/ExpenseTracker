package com.spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByuserName(String userName);

	Optional<Users> findByuserNameAndPassword(String un, String pwd);

}
