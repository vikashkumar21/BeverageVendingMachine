package com.interview.nestaway.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "inventory")
public class Inventory {
	
	@Id
	private String name;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Inventory [name=" + name + ", quantity=" + quantity + "]";
	}
}
