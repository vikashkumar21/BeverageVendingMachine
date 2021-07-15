package com.interview.nestaway.dao;

import java.util.Collection;
import java.util.List;

import com.interview.nestaway.entity.Inventory;

public interface InventoryDao {

	void saveToInventory(List<Inventory> inventoryList);

	List<Inventory> getInventory(Collection<String> ingredients);
	
	List<Inventory> getAllInventory();

	Inventory getOneInventory(String ingredient);

}
