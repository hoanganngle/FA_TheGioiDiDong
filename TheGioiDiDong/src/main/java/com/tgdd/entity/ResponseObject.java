package com.tgdd.entity;

import com.tgdd.dto.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObject {
	public ResponseObject(String string, String string2, CategoryDto updateCategory) {
		// TODO Auto-generated constructor stub
	}
	private String status;
	private String message;
	private Object data;
	
	
}
