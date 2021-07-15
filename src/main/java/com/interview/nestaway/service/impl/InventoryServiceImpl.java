package com.interview.nestaway.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.interview.nestaway.dao.InventoryDao;
import com.interview.nestaway.entity.Inventory;
import com.interview.nestaway.exception.IngredientOutOfStockException;
import com.interview.nestaway.model.Ingredient;
import com.interview.nestaway.service.InventoryService;
import com.interview.nestaway.tansformer.InventoryTransformer;

@Service
@Qualifier
public class InventoryServiceImpl implements InventoryService {

	private static final int  MAX_UNIT= 30;
	
	private final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

	@Autowired
	private InventoryDao inventoryDao;
	
	@Autowired
	private InventoryTransformer inventoryTransformer;
	
	@Override
	public void createInventory(List<String> ingredients) {
		logger.info("Inventory to be created with ingredients: {}", ingredients);
		List<Inventory> inventoryList = new ArrayList<>();
		for(String ingredient : ingredients) {
			Inventory inventory = new Inventory();
			inventory.setName(ingredient);
			inventory.setQuantity(fillInventory());
			inventoryList.add(inventory);
		}
		inventoryDao.saveToInventory(inventoryList);
		logger.info("Inventory created: {}", inventoryList);
	}
	
	@Override
	public void stockUpIngredients(List<String> ingredients) {
		List<Inventory> inventoryList = inventoryDao.getInventory(ingredients);
		for(Inventory inventory : inventoryList) {
			inventory.setQuantity(fillInventory());
		}
		inventoryDao.saveToInventory(inventoryList);
		logger.info("Inventory filled up: {}", inventoryList);
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		List<Inventory> inventoryList = inventoryDao.getAllInventory();
		logger.info("Inventory: {}", inventoryList);
		return inventoryTransformer.transformToIngreds(inventoryList);
	}
	
	@Override
	public List<Ingredient> getIngredients(List<String> ingredients) {
		List<Inventory> inventoryList = inventoryDao.getInventory(ingredients);
		logger.info("Inventory: {}", inventoryList);
		return inventoryTransformer.transformToIngreds(inventoryList);
	}
	
	@Override
	public Ingredient getIngredient(String ingredient) {
		Inventory oneInventory = inventoryDao.getOneInventory(ingredient);
		logger.info("One ingredient: {}", oneInventory);
		return inventoryTransformer.transformToIngreds(oneInventory);
	}
	
	@Override
	public void updateInventory(List<Ingredient> ingredients) throws IngredientOutOfStockException {
		Map<String, Ingredient> ingredMap = new HashMap<>();
		for(Ingredient ingred : ingredients) {
			ingredMap.put(ingred.getName(), ingred);
		}
		List<Inventory> inventoryList = inventoryDao.getInventory(ingredMap.keySet());
		for(Inventory inventory : inventoryList) {
			Ingredient ingredient = ingredMap.get(inventory.getName());
			int leftQuantity = inventory.getQuantity()-ingredient.getQuantity();
			if(leftQuantity<0) {
				throw new IngredientOutOfStockException(ingredient.getName());
			}
			inventory.setQuantity(leftQuantity);
		}
		inventoryDao.saveToInventory(inventoryList);
		logger.info("Updated inventory: {}", inventoryList);
	}
	
	private int fillInventory() {
		return MAX_UNIT;
	}
}
