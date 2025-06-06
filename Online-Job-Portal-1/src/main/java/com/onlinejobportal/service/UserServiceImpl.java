package com.onlinejobportal.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlinejobportal.model.User;
import com.onlinejobportal.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService, UserDetailsService {

   
    @Autowired
    private UserRepository userRepository;

   
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    @Override
    public User registerUser(User user) {
      
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }


        user.setPassword(passwordEncoder.encode(user.getPassword()));

     
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);  // Find the user by username
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
      
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

 
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

   
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

   
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}