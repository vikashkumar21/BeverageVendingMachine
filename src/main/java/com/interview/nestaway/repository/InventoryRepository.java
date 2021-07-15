package com.interview.nestaway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.nestaway.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
	
}
