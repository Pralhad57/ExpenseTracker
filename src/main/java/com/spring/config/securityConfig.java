package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spring.Service.login_service;

@Configuration
@EnableWebSecurity
public class securityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity sec) throws Exception {

		sec.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/loginpage").permitAll().requestMatchers("/login")
						.permitAll().requestMatchers("/register").permitAll().anyRequest().authenticated());

		return sec.build();

	}

	@Bean
	public BCryptPasswordEncoder passencode() {

		return new BCryptPasswordEncoder();
	}

	@Autowired
	private login_service loginservice;

	@Bean
	public AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception {

		DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider(loginservice);
		authprovider.setPasswordEncoder(passencode());

		return config.getAuthenticationManager();
	}

}
