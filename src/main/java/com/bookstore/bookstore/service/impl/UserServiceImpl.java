package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.domain.security.UserRole;
import com.bookstore.bookstore.domain.User;
import com.bookstore.bookstore.repository.RoleRepository;
import com.bookstore.bookstore.repository.UserRepository;
import com.bookstore.bookstore.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userRepository.findByUsername((user.getUsername()));

        if(localUser != null){
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        }else{
            for (UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            localUser = userRepository.save(user);
        }

        return localUser;
    }

}
