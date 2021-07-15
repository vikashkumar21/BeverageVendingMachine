package com.interview.nestaway.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.nestaway.dao.InventoryDao;
import com.interview.nestaway.entity.Inventory;
import com.interview.nestaway.model.Ingredient;
import com.interview.nestaway.tansformer.InventoryTransformer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { InventoryServiceImpl.class })
class InventoryServiceImplTest {
	
	@MockBean
	private InventoryDao inventoryDao;
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	@SpyBean
	private InventoryTransformer inventoryTransformer;

	@Test
	public void testGetAllIngredients() {
		
		List<Inventory> value = new ArrayList<>();
		Inventory inv = new Inventory();
		inv.setName("water"); inv.setQuantity(1);
		value.add(inv);
		when(inventoryDao.getAllInventory()).thenReturn(value);
		List<Ingredient> actual = inventoryServiceImpl.getAllIngredients();
		assertEquals(1, actual.get(0).getQuantity());
	}

}
