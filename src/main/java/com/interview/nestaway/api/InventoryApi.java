package com.interview.nestaway.api;

import java.util.List;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.nestaway.model.Ingredient;
import com.interview.nestaway.service.InventoryService;

@RestController
@RequestMapping(value = "/inventory/v1.0")
public class InventoryApi {
	
	private static final String EVENT = "EVENT";
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping(value = "/createinventory", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createInventory(@RequestBody(required = true) List<String> ingredients){
		
		MDC.put(EVENT, "create-inventory");
		inventoryService.createInventory(ingredients);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/topupingredients", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> stockUpIngredients(@RequestBody(required = true) List<String> ingredients){
		
		MDC.put(EVENT, "fill-ingredients");
		inventoryService.stockUpIngredients(ingredients);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getAllIngredients(){
		
		MDC.put(EVENT, "get-all-ingredients");
		return new ResponseEntity<>(inventoryService.getAllIngredients(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/ingredient/{ingredient}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingredient> getIngredient(@PathVariable("ingredient") String ingredient){
		
		MDC.put(EVENT, "get-one-ingredient");
		return new ResponseEntity<>(inventoryService.getIngredient(ingredient), HttpStatus.OK);
	}
	
	@PostMapping(value = "/get_ingredients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ingredient>> getIngredients(@RequestBody(required = true) List<String> ingredients){
		
		MDC.put(EVENT, "get-some-ingredients");
		return new ResponseEntity<>(inventoryService.getIngredients(ingredients), HttpStatus.OK);
	}
}
