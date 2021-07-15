package com.interview.nestaway.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BeverageService {

	List<String> getBeverages();

	String dispenseBeverage(String beverage);

}
