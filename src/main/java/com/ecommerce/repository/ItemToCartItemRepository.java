package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.ItemToCartItem;
import com.ecommerce.domain.CartItem;

public interface ItemToCartItemRepository extends CrudRepository<ItemToCartItem, Long>{
	void deleteByCartItem(CartItem cartItem);
}
