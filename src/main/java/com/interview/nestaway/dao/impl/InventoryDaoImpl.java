package com.interview.nestaway.dao.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.interview.nestaway.dao.InventoryDao;
import com.interview.nestaway.entity.Inventory;
import com.interview.nestaway.repository.InventoryRepository;

@Service
@Qualifier
public class InventoryDaoImpl implements InventoryDao {
	
	private final Logger logger = LoggerFactory.getLogger(InventoryDaoImpl.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public void saveToInventory(List<Inventory> inventoryList) {
		logger.info("Save all in inventory: {}", inventoryList);
		inventoryRepository.saveAll(inventoryList);
	}

	@Override
	public List<Inventory> getInventory(Collection<String> ingredients) {
		logger.info("Get inventory with ingredients: {}", ingredients);
		return inventoryRepository.findAllById(ingredients);
	}

	@Override
	public List<Inventory> getAllInventory() {
		logger.info("Get all inventory");
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory getOneInventory(String ingredient){
		logger.info("Get inventory for a ingredient: {}", ingredient);
		return inventoryRepository.getById(ingredient);
	}
}
