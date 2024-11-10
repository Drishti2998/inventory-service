package com.drishti.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drishti.inventory.dto.InventoryResponse;
import com.drishti.inventory.dto.InvetoryRequest;
import com.drishti.inventory.model.Inventory;
import com.drishti.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

	private final InventoryRepository inventoryRepository;

	public List<InventoryResponse> isInStock(List<String> skuCode) {
		//can uncomment if wanted to test inventory services
//		log.info("Wait Started");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.info("Wait Ended");
		List<InventoryResponse> inventoryResponse = skuCode.stream().map(this::mapToInventoryResponse).toList();
		return inventoryResponse;
	}

	public void createInventories(List<InvetoryRequest> inventoryRequest) {
		List<Inventory> inventoryList = inventoryRequest.stream().map(this::mapToDto).toList();
		inventoryRepository.saveAll(inventoryList);
	}

	private Inventory mapToDto(InvetoryRequest invetoryRequest) {
		Inventory inventory = Inventory.builder().skuCode(invetoryRequest.getSkuCode())
				.quantity(invetoryRequest.getQuantity()).build();

		return inventory;
	}

	public List<Inventory> getInventories() {
		return inventoryRepository.findAll();
	}

	private InventoryResponse mapToInventoryResponse(String skuCode) {
		InventoryResponse inventoryResponse = new InventoryResponse();
		Inventory inventory = inventoryRepository.findBySkuCode(skuCode);
		inventoryResponse.setInStock(inventory.getQuantity() > 0 ? true : false);
		inventoryResponse.setSkuCode(skuCode);
		return inventoryResponse;
	}

}
