package com.interview.nestaway.beverage;

import java.util.ArrayList;
import java.util.List;

import com.interview.nestaway.model.Ingredient;

public enum Coffee implements Beverage {
	BLACK_COFFEE(3, 1, 1, 0), 
	MILK_COFFEE(1, 1, 1, 2), 
	BLACK_COFFEE_SUGARLESS(3, 1, 0, 0), 
	MILK_COFFEE_SUGARLESS(1, 1, 0, 2);
	
	private int coffeeUnits;
	private int sugarUnits;
	private int waterUnits;
	private int milkUnits;
	
	private Coffee(int waterUnits, int coffeeUnits, int sugarUnits, int milkUnits) {
		this.coffeeUnits=coffeeUnits;
		this.sugarUnits=sugarUnits;
		this.waterUnits=waterUnits;
		this.milkUnits=milkUnits;
	}
	
	public int getCoffeeUnits() {
		return this.coffeeUnits;
	}

	public int getSugarUnits() {
		return this.sugarUnits;
	}

	public int getWaterUnits() {
		return this.waterUnits;
	}

	public int getMilkUnits() {
		return this.milkUnits;
	}

	@Override
	public String getBeverage() {
		return name();
	}
	
	public List<Ingredient> ingredients(){
		Ingredient water = new Ingredient("water", this.waterUnits);
		Ingredient coffee = new Ingredient("coffee", this.coffeeUnits);
		Ingredient sugar = new Ingredient("sugar", this.sugarUnits);
		Ingredient milk = new Ingredient("milk", this.milkUnits);
		List<Ingredient> list = new ArrayList<>();
		list.add(water);list.add(coffee);list.add(milk);list.add(sugar);
		return list;
	}
}
