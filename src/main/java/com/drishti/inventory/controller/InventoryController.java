package com.drishti.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.drishti.inventory.dto.InventoryResponse;
import com.drishti.inventory.dto.InvetoryRequest;
import com.drishti.inventory.model.Inventory;
import com.drishti.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {
	
	@Value("${server.port}")
	private String port;

	private final InventoryService inventoryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createInventories(@RequestBody List<InvetoryRequest> inventoryRequest) {
		inventoryService.createInventories(inventoryRequest);
		return "Inventory Saved Successfully";
		
	}
	
	@GetMapping("/getAllInventory")
	@ResponseStatus(HttpStatus.OK)
	public List<Inventory> findAllInventory(){
		return inventoryService.getInventories();
	}
	

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
		log.info("In which port--->"+  port);
		return inventoryService.isInStock(skuCode);

	}

}
