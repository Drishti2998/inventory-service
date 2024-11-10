package com.drishti.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drishti.inventory.dto.InventoryResponse;
import com.drishti.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	Inventory findBySkuCode(String skuCode);

}
