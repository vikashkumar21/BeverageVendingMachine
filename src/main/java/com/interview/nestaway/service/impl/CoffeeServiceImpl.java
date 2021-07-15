package com.interview.nestaway.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.interview.nestaway.beverage.Coffee;
import com.interview.nestaway.exception.IngredientOutOfStockException;
import com.interview.nestaway.model.Ingredient;
import com.interview.nestaway.service.BeverageService;
import com.interview.nestaway.service.InventoryService;

@Service
@Qualifier
public class CoffeeServiceImpl implements BeverageService{
	
	private final Logger logger = LoggerFactory.getLogger(CoffeeServiceImpl.class);
	
	@Autowired
	private InventoryService inventoryService;

	@Override
	public List<String> getBeverages() {
		List<String> beverages = new ArrayList<>();
		for(Coffee coffee : Coffee.values()) {
			beverages.add(coffee.getBeverage());
		}
		logger.info("Get beverages: {}", beverages);
		return beverages;
	}

	@Override
	public String dispenseBeverage(String beverage) {
		logger.info("Dispense beverages {}", beverage);
		Coffee coffee = null;
		for(Coffee coff : Coffee.values()) {
			if(coff.name().equals(beverage)) {
				coffee=coff;
				break;
			}
		}
		List<Ingredient> ingredients = coffee.ingredients();
		try {
			inventoryService.updateInventory(ingredients);
		}catch (IngredientOutOfStockException exception) {
			logger.error("Ingredient {} for the coffee: {} is out of stock", exception.getIngredient(), beverage);
			return "";
		}
		logger.info("Inventory updated after beverage dispense");
		return coffee.toString();
	}

}
