package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
