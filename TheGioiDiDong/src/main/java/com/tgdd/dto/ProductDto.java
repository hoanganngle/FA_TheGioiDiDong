package com.tgdd.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.tgdd.entity.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	private Integer productId;

	@NotNull(message = "Price must not be null")
	@Min(value = 0, message = "Price >= 0")
	private double price;
	
	@NotEmpty(message = "productName must not be empty")
	private String productName;
	@NotNull(message = "quantity must not be null")
	@Min(value = 0, message = "Quantity >= 1")
	private int quantity;

	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



}
