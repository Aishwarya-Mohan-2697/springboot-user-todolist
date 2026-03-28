package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAuthViewEntity;
import com.example.demo.repository.UserAuthViewRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAuthViewRepository userAuthViewRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthViewEntity user = userAuthViewRepository.findByUserName(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return Spring Security User object
        return new User(
                user.getUserName(),
                user.getUserPassword(),
                new ArrayList<>() // Authorities/roles - empty for now
        );
    }
}
