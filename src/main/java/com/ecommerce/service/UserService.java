package com.ecommerce.service;

import java.util.Set;

import com.ecommerce.domain.User;
import com.ecommerce.domain.UserBilling;
import com.ecommerce.domain.UserPayment;
import com.ecommerce.domain.UserShipping;
import com.ecommerce.domain.security.UserRole;

public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles);

	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User save(User user);
	
	User findById(Long id);
	
	void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShipping(Long userShippingId, User user);
	
}
