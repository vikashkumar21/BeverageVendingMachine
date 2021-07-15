package com.interview.nestaway.dao.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.nestaway.dao.InventoryDao;
import com.interview.nestaway.entity.Inventory;
import com.interview.nestaway.repository.InventoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { InventoryDaoImpl.class })
class InventoryDaoImplTest {
	
	@Autowired
	private InventoryDao inventorydao;
	
	@MockBean
	private InventoryRepository inventoryRepository;

	@Test
	public void testGetInventory() {
		List<String> ingredients = new ArrayList<>();
		ingredients.add("coffee");
		List<Inventory> inventory = new ArrayList<>();
		Inventory inv = new Inventory();
		inv.setName("coffee");inv.setQuantity(10);
		inventory.add(inv);
		when(inventoryRepository.findAllById(ingredients)).thenReturn(inventory);
		List<Inventory> actual = inventorydao.getInventory(ingredients);
		assertEquals(inventory.get(0).getQuantity(), actual.get(0).getQuantity());
	}

}
