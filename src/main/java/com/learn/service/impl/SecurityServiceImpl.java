package com.learn.service.impl;

import com.learn.entity.User;
import com.learn.entity.common.UserPrincipal;
import com.learn.repository.UserRepository;
import com.learn.service.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserNameAndIsDeleted(username, false);

        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}
