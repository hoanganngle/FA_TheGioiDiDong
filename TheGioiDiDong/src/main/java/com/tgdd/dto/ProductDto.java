package com.tgdd.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.tgdd.entity.Category;
import com.tgdd.entity.Manufacturer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
	private Long productId;

	@NotNull(message = "Price must not be null")
	@Min(value = 0, message = "Price >= 0")
	private double price;
	
	@NotEmpty(message = "productName must not be empty")
	private String productName;
	@NotNull(message = "quantity must not be null")
	@Min(value = 0, message = "Quantity >= 1")
	private int quantity;
	
	private int Product_Warranty;
	
	private String Description;
	
	private String Store_Name;
	
	private String Status;
	
	private int unit;

	private Category category;
	
	private Manufacturer manufacturer;
	



}
