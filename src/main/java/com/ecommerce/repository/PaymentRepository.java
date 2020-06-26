package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
