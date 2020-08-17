package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.UserRegistrationDto;
import com.example.demo.model.User;

public interface UserService extends UserDetailsService {

	User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
