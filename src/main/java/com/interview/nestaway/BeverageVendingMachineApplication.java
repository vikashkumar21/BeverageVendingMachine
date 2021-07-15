package com.interview.nestaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.interview.nestaway"})
public class BeverageVendingMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeverageVendingMachineApplication.class, args);
	}

}
