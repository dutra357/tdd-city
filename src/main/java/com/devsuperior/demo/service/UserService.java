package com.devsuperior.demo.service;

import com.devsuperior.demo.entities.Role;
import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.repository.UserRepository;
import com.devsuperior.demo.repository.projections.UserDetailsProjection;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<UserDetailsProjection> projections = repository.searchUserAndRolesByEmail(username);

        if (projections.size() == 0) {
            throw new UsernameNotFoundException("Username not found.");
        }

        User user = new User();
        user.setPassword(projections.get(0).getPassword());
        user.setEmail(projections.get(0).getUsername());

        for (UserDetailsProjection projectionEntity : projections) {
            user.addRole(new Role(projectionEntity.getRoleId(), projectionEntity.getAuthority()));
        }
        return user;
    }
}
