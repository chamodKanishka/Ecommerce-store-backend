package com.ecommerce.service;

import java.util.List;

import com.ecommerce.domain.Item;
import com.ecommerce.domain.CartItem;
import com.ecommerce.domain.ShoppingCart;
import com.ecommerce.domain.User;

public interface CartItemService {
	
	CartItem addItemToCartItem(Item item, User user, int qty);
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
//	List<CartItem> findByOrder(Order order);
	
	CartItem updateCartItem(CartItem cartItem);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem findById(Long id);
	
	CartItem save(CartItem cartItem);

}
