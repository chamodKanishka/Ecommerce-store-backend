package com.ecommerce.repository;

import java.util.List;

import com.ecommerce.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{
	List<Item> findByTitleContaining(String keyword);
}
