package com.ecommerce.service;

import com.ecommerce.domain.UserShipping;

public interface UserShippingService {
	
	UserShipping findById(Long id);
	
	void removeById(Long id);

}
