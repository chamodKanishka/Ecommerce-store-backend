package com.ecommerce.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.CartItem;
import com.ecommerce.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
}
