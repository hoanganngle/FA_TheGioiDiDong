package com.tgdd.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable{
	private Integer categoryId;
	@NotEmpty
	private String categoryName;
	private Boolean isEdit = false;
}
