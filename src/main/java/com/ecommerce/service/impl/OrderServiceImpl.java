package com.ecommerce.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.BillingAddress;
import com.ecommerce.domain.Item;
import com.ecommerce.domain.CartItem;
import com.ecommerce.domain.Order;
import com.ecommerce.domain.Payment;
import com.ecommerce.domain.ShippingAddress;
import com.ecommerce.domain.ShoppingCart;
import com.ecommerce.domain.User;
import com.ecommerce.repository.BillingAddressRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.PaymentRepository;
import com.ecommerce.repository.ShippingAddressRepository;
import com.ecommerce.service.ItemService;
import com.ecommerce.service.CartItemService;
import com.ecommerce.service.OrderService;
import com.ecommerce.utility.MailConstructor;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	public synchronized  Order createOrder(
			ShoppingCart shoppingCart,
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user
			){
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			Item item = cartItem.getItem();
			cartItem.setOrder(order);
			item.setInStockNumber(item.getInStockNumber()-cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}

}
