package com.ecommerce.service;

import java.util.List;

import com.ecommerce.domain.Item;

public interface ItemService {
	
	List<Item> findAll();
	
	Item findOne(Long id);
	
	Item save(Item item);
	
	List<Item> blurrySearch(String title);
	
	void removeOne(Long id);
}
