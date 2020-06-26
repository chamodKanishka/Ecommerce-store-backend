package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long>{

}
