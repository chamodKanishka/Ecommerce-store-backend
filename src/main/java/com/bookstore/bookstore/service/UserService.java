package com.bookstore.bookstore.service;

import com.bookstore.bookstore.domain.User;
import com.bookstore.bookstore.domain.security.UserRole;

import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles);
}
