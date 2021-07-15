package com.interview.nestaway.exception;

public class IngredientOutOfStockException extends Exception {
	
	private String ingredient;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IngredientOutOfStockException(String ingredient) {
		super();
		this.ingredient=ingredient;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	
	@Override
	public String getMessage() {
		return String.format("Ingredient %s out of stock", ingredient);
	}
}
