package com.ecommerce.service;

import com.ecommerce.domain.BillingAddress;
import com.ecommerce.domain.Order;
import com.ecommerce.domain.Payment;
import com.ecommerce.domain.ShippingAddress;
import com.ecommerce.domain.ShoppingCart;
import com.ecommerce.domain.User;

public interface OrderService {
	
	Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
	);

}
