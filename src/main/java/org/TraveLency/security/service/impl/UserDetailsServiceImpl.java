package org.TraveLency.security.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.User;
import org.TraveLency.repository.UserRepository;
import org.TraveLency.security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrLogin(usernameOrEmail, usernameOrEmail);
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new MainException("User with such id is not found", 404L));
        return UserPrincipal.create(user);
    }
}
