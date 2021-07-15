package com.interview.nestaway.tansformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interview.nestaway.entity.Inventory;
import com.interview.nestaway.model.Ingredient;

@Service
public class InventoryTransformer {

	public List<Inventory> transformToInventory(List<Ingredient> ingredients) {
		List<Inventory> inventoryList = new ArrayList<>();
		for(Ingredient ingred : ingredients) {
			Inventory inventory = new Inventory();
			inventory.setName(ingred.getName());
			inventory.setQuantity(ingred.getQuantity());
			inventoryList.add(inventory);
		}
		return inventoryList;
	}

	public List<Ingredient> transformToIngreds(List<Inventory> inventoryList) {
		List<Ingredient> ingredients = new ArrayList<>();
		for(Inventory inventory : inventoryList) {
			Ingredient ingred = new Ingredient();
			ingred.setName(inventory.getName());
			ingred.setQuantity(inventory.getQuantity());
			ingredients.add(ingred);
		}
		return ingredients;
	}

	public Ingredient transformToIngreds(Inventory inventory) {
		Ingredient ingred = new Ingredient();
		ingred.setName(inventory.getName());
		ingred.setQuantity(inventory.getQuantity());
		return ingred;
	}
	
	public Inventory transformToInventory(Ingredient ingred) {
		Inventory inventory = new Inventory();
		inventory.setName(ingred.getName());
		inventory.setQuantity(ingred.getQuantity());
		return inventory;
	}
}
