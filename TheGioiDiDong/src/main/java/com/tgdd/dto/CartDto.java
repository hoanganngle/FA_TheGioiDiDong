package com.tgdd.dto;

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
	
	private float price;
	
	private Long order_id;
	
	private Long phone_number;
	
	private Long product_id;
	
	private Long store_id;
	
	

}
