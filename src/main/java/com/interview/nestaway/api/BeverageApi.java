package com.interview.nestaway.api;

import java.util.List;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.nestaway.service.BeverageService;

@RestController
@RequestMapping(value = "/beverage/v1.0")
public class BeverageApi {
	
	@Autowired
	private BeverageService beverageService;
	
	@GetMapping(value = "/beverages")
	public ResponseEntity<List<String>> displayBeverage() {
		
		MDC.put("EVENT", "get-all-beverages");
		List<String> beverages = beverageService.getBeverages();
		return new ResponseEntity<>(beverages, HttpStatus.OK);
	}
	
	@GetMapping(value = "/dispense/{beverage}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getBeverage(@PathVariable("beverage") String beverage){
		
		MDC.put("EVENT", "dispense-beverage");
		String service = beverageService.dispenseBeverage(beverage);
		if(service.isEmpty()) {
			return new ResponseEntity<>(String.format("Beverage not dispensable: %s", beverage), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(service, HttpStatus.OK);
	}
}
