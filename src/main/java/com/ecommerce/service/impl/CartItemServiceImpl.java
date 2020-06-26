package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.domain.Item;
import com.ecommerce.domain.ItemToCartItem;
import com.ecommerce.domain.CartItem;
import com.ecommerce.domain.ShoppingCart;
import com.ecommerce.domain.User;
import com.ecommerce.repository.ItemToCartItemRepository;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ItemToCartItemRepository itemToCartItemRepository;

	public CartItem addItemToCartItem(Item item, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem : cartItemList) {
			if (item.getId() == cartItem.getItem().getId()) {
				cartItem.setQty(cartItem.getQty()+qty);
				cartItem.setSubtotal(new BigDecimal(item.getOurPrice()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setItem(item);
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(item.getOurPrice()).multiply(new BigDecimal(qty)));
		
		cartItem =cartItemRepository.save(cartItem);
		
		ItemToCartItem itemToCartItem = new ItemToCartItem();
		itemToCartItem.setItem(item);
		itemToCartItem.setCartItem(cartItem);
		itemToCartItemRepository.save(itemToCartItem);
		
		return cartItem;
	}
	
	@Transactional
	public void removeCartItem(CartItem cartItem) {
		itemToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
	}
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getItem().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
		
	}
	
	public CartItem findById(Long id) {
		return cartItemRepository.findOne(id);
	}
	
	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
//	public List<CartItem> findByOrder(Order order) {
//		return cartItemRepository.findByOrder(order);
//	}
}
