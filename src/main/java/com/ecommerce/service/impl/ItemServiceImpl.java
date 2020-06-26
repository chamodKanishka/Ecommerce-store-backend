package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.Item;
import com.ecommerce.repository.ItemRepository;
import com.ecommerce.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll() {
		List<Item> itemList = (List<Item>) itemRepository.findAll();
		
		List<Item> activeItemList = new ArrayList<>();
		
		for (Item item : itemList) {
			if(item.isActive()) {
				activeItemList.add(item);
			}
		}
		
		return activeItemList;
	}
	
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}
	
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public List<Item> blurrySearch(String keyword) {
		List<Item> itemList = itemRepository.findByTitleContaining(keyword);
		
		List<Item> activeItemList = new ArrayList<>();
		
		for (Item item : itemList) {
			if(item.isActive()) {
				activeItemList.add(item);
			}
		}
		
		return activeItemList;
	}
	
	public void removeOne(Long id) {
		itemRepository.delete(id);
	}
}
