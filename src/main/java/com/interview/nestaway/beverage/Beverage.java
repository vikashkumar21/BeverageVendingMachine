package com.interview.nestaway.beverage;

import java.util.List;

import com.interview.nestaway.model.Ingredient;

public interface Beverage {
	
	String getBeverage();
	List<Ingredient> ingredients();
}
