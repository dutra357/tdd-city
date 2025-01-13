package com.devsuperior.demo.service;

import com.devsuperior.demo.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserRepository repository;
    public UserService(@Lazy PasswordEncoder bCryptPasswordEncoder, UserRepository repository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
