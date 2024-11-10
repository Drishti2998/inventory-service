package com.drishti.inventory.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvetoryRequest {
	
	private Long id;
	private String skuCode;
	private Integer quantity;


}
