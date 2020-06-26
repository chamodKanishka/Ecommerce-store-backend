package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.UserBilling;

public interface UserBillingRepository extends CrudRepository<UserBilling, Long> {

}
