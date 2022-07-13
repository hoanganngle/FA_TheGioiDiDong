package com.tgdd.dto;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
	private Long cart_id;
	
	@Min(value = 1, message = " Quantity >= 1")
	private int quantity;
	
	private Long order_id;
	
	private Long phone_number;
	
	private Long product_id;
	
	private Long store_id;
	
	

}
