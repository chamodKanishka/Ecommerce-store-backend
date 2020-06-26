package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
	
}
