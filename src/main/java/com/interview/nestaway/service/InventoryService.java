package com.interview.nestaway.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interview.nestaway.exception.IngredientOutOfStockException;
import com.interview.nestaway.model.Ingredient;

@Service
public interface InventoryService {

	void stockUpIngredients(List<String> ingredients);

	List<Ingredient> getAllIngredients();

	List<Ingredient> getIngredients(List<String> ingreds);

	Ingredient getIngredient(String ingred);
	
	void updateInventory(List<Ingredient> ingredients) throws IngredientOutOfStockException;

	void createInventory(List<String> ingredients);

}
