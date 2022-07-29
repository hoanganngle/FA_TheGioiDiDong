package com.tgdd.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {


	private Long productId;

	private String productName;
	private Double price;

	private Integer productWarranty;
	private String image;
	private String description;

	private String storeName;
	private Boolean status;
	private Integer unit;

	private ManufacturerDto manufacturer;

	private CategoryDto category;
	

}
