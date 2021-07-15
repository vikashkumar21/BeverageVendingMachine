package com.interview.nestaway.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.nestaway.exception.IngredientOutOfStockException;
import com.interview.nestaway.model.Ingredient;
import com.interview.nestaway.service.InventoryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CoffeeServiceImpl.class})
class CoffeeServiceImplTest {
	
	@Autowired
	private CoffeeServiceImpl coffeeServiceImpl;
	
	@MockBean
	private InventoryService inventoryService;

	@Test
	public void testDispenseBeverage() {
		
		String beverage="MILK_COFFEE";
		
		String actual = coffeeServiceImpl.dispenseBeverage(beverage);
		assertEquals(beverage, actual);
	}
	
	@Test
	public void testDispenseBeverageNegative() throws IngredientOutOfStockException {
		
		String beverage="MILK_COFFEE";
		doThrow(new IngredientOutOfStockException(beverage)).when(inventoryService).updateInventory(ArgumentMatchers.<Ingredient>anyList());
		String actual = coffeeServiceImpl.dispenseBeverage(beverage);
		assertEquals("", actual);
	}
}
