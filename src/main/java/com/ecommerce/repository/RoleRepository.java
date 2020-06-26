package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
