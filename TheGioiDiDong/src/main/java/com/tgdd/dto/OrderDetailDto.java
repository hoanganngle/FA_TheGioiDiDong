package com.tgdd.dto;

import com.tgdd.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDto {
	private Long orderDetailId;
	private Integer price;
	private Integer quantity;
	private Product products;

}
